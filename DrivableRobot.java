package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DrivableRobot {
    HardwareMap hwMap;
    private DcMotor backLeft, frontLeft, frontRight, backRight;
    private BNO055IMU imu;

    DrivableRobot(HardwareMap hm) {
	   hwMap = hm;
	   backLeft = hwMap.dcMotor.get("back_left_motor");
	   frontLeft = hwMap.dcMotor.get("front_left_motor");
	   frontRight = hwMap.dcMotor.get("front_right_motor");
	   backRight = hwMap.dcMotor.get("back_right_motor");

	   imu = hwMap.get(BNO055IMU.class, "imu");
	   BNO055IMU.Parameters params = new BNO055IMU.Parameters();
	   imu.initialize(params);
    }

    public void setPower(double p1, double p2, double p3, double p4) {
	   backLeft.setPower(p1);
	   frontLeft.setPower(p2);
	   frontRight.setPower(p3);
	   backRight.setPower(p4);
    }

    public void setPower(double p) {
	   setPower(p, p, p, p);
    }

    public void setDirection(DcMotorSimple.Direction d1, DcMotorSimple.Direction d2,
					    DcMotorSimple.Direction d3, DcMotorSimple.Direction d4) {
	   backLeft.setDirection(d1);
	   frontLeft.setDirection(d2);
	   frontRight.setDirection(d3);
	   backRight.setDirection(d4);
    }

    public void setDirection(DcMotorSimple.Direction left, DcMotorSimple.Direction right) {
	   setDirection(left, left, right, right);
    }

    public void driveForward() {
	   setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE,
			 DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
	   setPower(1);
    }

    public void driveBackward() {
	   setDirection(DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD,
			 DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE);
	   setPower(1);
    }

    public void turnRight() {
	   setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE,
			 DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE);
	   setPower(1);
    }

    public void turnLeft() {
	   setDirection(DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD,
			 DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
	   setPower(1);
    }

    public void slideRight() {
	   setDirection(DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE,
			 DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD);
	   setPower(1);
    }

    public void slideLeft() {
	   setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD,
			 DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE);
	   setPower(1);
    }

    public void driveForwardLeft() {
	   setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE,
			 DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
	   setPower(1,0,1,0);
    }

    public void driveForwardRight() {
	   setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE,
			 DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
	   setPower(0,1,0,1);
    }

    public void driveBackwardLeft() {
	   setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD,
			 DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE);
	   setPower(0,1,0,1);
    }

    public void driveBackwardRight() {
	   setDirection(DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE,
			 DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD);
	   setPower(1,0,1,0);

    }




    public void stopDriving() {
	   setPower(0);
    }


}
