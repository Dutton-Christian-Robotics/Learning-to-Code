package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.matrices.GeneralMatrixF;
import org.firstinspires.ftc.robotcore.external.matrices.MatrixF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class ComplexEncoderRobot {
    HardwareMap hwMap;
    public DcMotor backLeft, frontLeft, frontRight, backRight;
    private final double maxPower = 1.0;

    private MatrixF conversion;
    private final GeneralMatrixF encoderMatrix = new GeneralMatrixF(3, 1);

    public static double GEAR_RATIO = 1.0; // for simulator - ours should be 0.5f;
    public static double WHEEL_RADIUS = 5.0;  // 5 cm
    public static double TICKS_PER_ROTATION = 1120.0;  // From NeveRest (for simulator)  GoBilda should be 383.6f
    public static double CM_PER_TICK = (2 * Math.PI * GEAR_RATIO * WHEEL_RADIUS) / TICKS_PER_ROTATION;

    private int frontLeftOffset;
    private int frontRightOffset;
    private int backRightOffset;
    private int backLeftOffset;

    private BNO055IMU imu;
    private Telemetry telemetry;

    ComplexEncoderRobot(HardwareMap hm, Telemetry t) {
	   hwMap = hm;
	   telemetry = t;
	   backLeft = hwMap.dcMotor.get("back_left_motor");
	   frontLeft = hwMap.dcMotor.get("front_left_motor");
	   frontRight = hwMap.dcMotor.get("front_right_motor");
	   backRight = hwMap.dcMotor.get("back_right_motor");

	   imu = hwMap.get(BNO055IMU.class, "imu");
	   BNO055IMU.Parameters params = new BNO055IMU.Parameters();
	   imu.initialize(params);

	   float[] data = {1.0f, 1.0f, 1.0f,
			 1.0f, -1.0f, -1.0f,
			 1.0f, -1.0f, 1.0f};
	   conversion = new GeneralMatrixF(3, 3, data);
	   conversion = conversion.inverted();


    }

    public void setPower(double bl, double fl, double fr, double br) {
	   backLeft.setPower(bl);
	   frontLeft.setPower(fl);
	   frontRight.setPower(fr);
	   backRight.setPower(br);
    }

    public void setPower(double p) {
	   setPower(p, p, p, p);
    }

    public void setMotorDirection(DcMotorSimple.Direction bl, DcMotorSimple.Direction fl,
						    DcMotorSimple.Direction fr, DcMotorSimple.Direction br) {
	   backLeft.setDirection(bl);
	   frontLeft.setDirection(fl);
	   frontRight.setDirection(fr);
	   backRight.setDirection(br);
    }

    public void setMotorDirection(DcMotorSimple.Direction left, DcMotorSimple.Direction right) {
	   setMotorDirection(left, left, right, right);
    }

    private void setProportionalPower(double bl, double fl, double fr, double br) {
	   double largest = maxPower;
	   largest = Math.max(largest, Math.abs(bl));
	   largest = Math.max(largest, Math.abs(fl));
	   largest = Math.max(largest, Math.abs(fr));
	   largest = Math.max(largest, Math.abs(br));

	   backLeft.setPower(bl / largest);
	   frontLeft.setPower(fl / largest);
	   frontRight.setPower(fr / largest);
	   backRight.setPower(br / largest);
    }


    public void drive(double forward, double strafe, double rotate) {
	   setMotorDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE,
			 DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);

	   double backLeftPower = forward - strafe + rotate;
	   double frontLeftPower = forward + strafe + rotate;
	   double frontRightPower = forward - strafe - rotate;
	   double backRightPower = forward + strafe - rotate;

	   setProportionalPower(backLeftPower, frontLeftPower, frontRightPower, backRightPower);
    }

    public void stopDriving() {
	   setPower(0);
    }

    public double powerDropoff(double target, double current) {
	   return 1 - Math.pow(1 - ((target - (current - 1)) / Math.abs(target - current)), 14);

    }

    public void setEncoderOffsets() {

	   frontRightOffset = frontRight.getCurrentPosition();
	   frontLeftOffset = frontLeft.getCurrentPosition();
	   backLeftOffset = backLeft.getCurrentPosition();
	   backRightOffset = backRight.getCurrentPosition();
    }


    double[] getDistanceCm() {
	   double[] distances = {0.0, 0.0};

	   encoderMatrix.put(0, 0, (float) ((frontLeft.getCurrentPosition() - frontLeftOffset) * CM_PER_TICK));
	   encoderMatrix.put(1, 0, (float) ((frontRight.getCurrentPosition() - frontRightOffset) * CM_PER_TICK));
	   encoderMatrix.put(2, 0, (float) ((backLeft.getCurrentPosition() - backLeftOffset) * CM_PER_TICK));

	   MatrixF distanceMatrix = conversion.multiplied(encoderMatrix);
	   distances[0] = distanceMatrix.get(0, 0);
	   distances[1] = distanceMatrix.get(1, 0);

	   return distances;
    }

    public void driveToPosition(double x, double y, double heading) {

	   double[] d = getDistanceCm();
	   double deltaY, deltaX, deltaH;
	   double pX, pY, pH;
	   double h = currentHeading();
	   double rotation = 0;
	   double averageError = 0;

	   while ((Math.abs(y - d[0]) > 1.5) || (Math.abs(x - d[1]) > 1.5) || (Math.abs(heading - h) > 1.5)) {
		  deltaX = x - d[1];
		  deltaY = y - d[0];
		  deltaH = h - heading;
		  telemetry.addData("x", deltaX);
		  telemetry.addData("y", deltaY);
		  telemetry.addData("h", deltaH);




//            if (h > heading) {
//                rotation = 0.5;
//            } else if (h < heading) {
//                rotation = -0.5;
//            }


		  averageError = (Math.abs(deltaX) + Math.abs(deltaY) + Math.abs(deltaH)) / 3;
		  telemetry.addData("Avg", averageError);
//            pX = powerDropoff(x, d[1]);
//            pY = powerDropoff(y, d[0]);
//            pH = powerDropoff(heading, h);

//            pX = powerDropoff(x, d[1]) * (deltaX / averageError);
//            pY = powerDropoff(y, d[0]) * (deltaY / averageError);
//            pH = powerDropoff(heading, h) * (deltaH / averageError);
		  pX = (deltaX / averageError);
		  pY = (deltaY / averageError);
		  pH = (deltaH / averageError);

		  telemetry.addData("px", pX);
		  telemetry.addData("py", pY);
		  telemetry.addData("ph", pH);


		  telemetry.update();
//            drive(powerDropoff(y, d[0]), powerDropoff(x, d[1]), 0);
		  drive(pY, pX, pH);
		  d = getDistanceCm();
		  h = currentHeading();
	   }
	   stopDriving();

    }

    public void driveToPosition(double x, double y) {
	   driveToPosition(x, y, 0.0);
    }

    public double currentHeading() {
	   Orientation orientation = imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
	   return orientation.thirdAngle;
    }

    public boolean between(double x, double min, double max) {
	   return (x > min) && (x < max);
    }

    public void comeToHeading(double angle, double maxPower, double tolerance, double timeout) {
	   double difference, absDifference;
	   boolean keepTurning = true;
	   ElapsedTime timer = new ElapsedTime();
	   Orientation orientation;

	   do {
		  orientation = imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
		  difference = orientation.thirdAngle - angle;
		  absDifference = Math.abs(difference);
		  telemetry.addData("r", absDifference);




		  if (between(absDifference, tolerance, 2 * tolerance) && (difference < 0)) {
			 telemetry.addData("l slow", "");
			 drive(0, 0, -1 * maxPower / 8);
			 try {
				Thread.sleep(25);
			 } catch (InterruptedException exc) {
				Thread.currentThread().interrupt();
			 }
		  } else if (between(absDifference, tolerance, 4 * tolerance) && (difference < 0)) {
			 telemetry.addData("l med", "");
			 drive(0, 0, -1 * maxPower / 4);
			 try {
				Thread.sleep(25);
			 } catch(InterruptedException exc){
				Thread.currentThread().interrupt();
			 }
		  } else if ((absDifference > 4 * tolerance)  && (difference < 0)) {
			 telemetry.addData("l fast", "");
			 drive(0, 0, -1 * maxPower);
			 try {
				Thread.sleep(25);
			 } catch(InterruptedException exc){
				Thread.currentThread().interrupt();
			 }

		  } else if (between(absDifference, tolerance, 2 * tolerance) && (difference > 0)) {
			 telemetry.addData("r slow", "");
			 drive(0, 0, maxPower / 8);
			 try {
				Thread.sleep(25);
			 } catch(InterruptedException exc){
				Thread.currentThread().interrupt();
			 }
		  } else if (between(absDifference, tolerance, 4 * tolerance) && (difference > 0)) {
			 telemetry.addData("l med", "");
			 drive(0, 0, maxPower / 4);
			 try {
				Thread.sleep(25);
			 } catch(InterruptedException exc){
				Thread.currentThread().interrupt();
			 }

		  } else if ((absDifference > 4 * tolerance) && (difference > 0)) {
			 telemetry.addData("r fast", "");
			 drive(0, 0, maxPower);
			 try {
				Thread.sleep(25);
			 } catch (InterruptedException exc) {
				Thread.currentThread().interrupt();
			 }
		  } else {
			 keepTurning = false;
			 stopDriving();
		  }
		  if (timer.milliseconds() >= timeout) {
			 keepTurning = false;
		  }
		  telemetry.update();
	   } while (keepTurning);

    }

    public void comeToHeading(double angle) {
	   comeToHeading(angle, 1, 1.5, 10000);
    }



}
