package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.matrices.GeneralMatrixF;
import org.firstinspires.ftc.robotcore.external.matrices.MatrixF;

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

    ComplexEncoderRobot(HardwareMap hm) {
	   hwMap = hm;
	   backLeft = hwMap.dcMotor.get("back_left_motor");
	   frontLeft = hwMap.dcMotor.get("front_left_motor");
	   frontRight = hwMap.dcMotor.get("front_right_motor");
	   backRight = hwMap.dcMotor.get("back_right_motor");

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

    public void driveToPosition(double x, double y) {

	   double[] d = getDistanceCm();
	   double deltaY = Math.abs(y - d[0]);
	   double deltaX = Math.abs(x - d[1]);
	   while ((Math.abs(y - d[0]) > 1.5) || (Math.abs(x - d[1]) > 1.5)) {
		  drive(powerDropoff(y, d[0]), powerDropoff(x, d[1]), 0);
		  d = getDistanceCm();
	   }
	   stopDriving();


    }

}
