package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PowerRatioRobot {
	HardwareMap hwMap;
	public DcMotor motorBackLeft, motorFrontLeft, motorFrontRight, motorBackRight;

	BetterDrivableRobot(HardwareMap hm) {
		hwMap = hm;
		motorBackLeft = hwMap.dcMotor.get("back_left_motor");
		motorFrontLeft = hwMap.dcMotor.get("front_left_motor");
		motorFrontRight = hwMap.dcMotor.get("front_right_motor");
		motorBackRight = hwMap.dcMotor.get("back_right_motor");
		motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
		motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);

	}

	public void setPower(double bl, double fl, double fr, double br) {
		motorBackLeft.setPower(bl);
		motorFrontLeft.setPower(fl);
		motorFrontRight.setPower(fr);
		motorBackRight.setPower(br);		
	}
	
	public void setPower(double p) {
		setPower(p, p, p, p);
	}


	public void driveForward(double p) {
		setPower(p, p, p, p);
	}
	public void driveForward() {
		driveForward(1);
	}
	
	public void driveBackward(double p) {
		setPower(-1 * p, -1 * p, -1 * p, -1 * p);
	}
	public void driveBackward() {
		driveBackward(1);
	}
	
	public void stopDriving() {
		setPower(0, 0, 0, 0);
	}
	
	public void turnLeft(double p) {
		setPower(-1 * p, -1 * p, p, p);
	}
	public void turnLeft() {
		turnLeft(1);
	}
	
	public void turnRight(double p) {
		setPower(p, p, -1 * p, -1 * p);
	}
	public void turnRight() {
		turnRight(1);
	}
	
	public void strafeRight(double p) {
		setPower(-1 * p, p, -1 * p, p);
	}
	public void strafeRight() {
		strafeRight(1);
	}
	
	public void strafeLeft(double p) {
		setPower(p, -1 * p, p, -1 * p);
	}
	public void strafeLef() {
		strafeLeft(1);
	}

}
