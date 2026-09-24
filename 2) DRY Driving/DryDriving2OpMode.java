package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "DRY Driving 2", group = "Learning")
public class DryDriving2OpMode extends LinearOpMode {

	DcMotor motorBackLeft;
	DcMotor motorFrontLeft;
	DcMotor motorFrontRight;
	DcMotor motorBackRight;

	public void setup() {
		motorBackLeft = hardwareMap.dcMotor.get("back_left_motor");
		motorFrontLeft = hardwareMap.dcMotor.get("front_left_motor");
		motorFrontRight = hardwareMap.dcMotor.get("front_right_motor");
		motorBackRight = hardwareMap.dcMotor.get("back_right_motor");

		motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
		motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
	}


	// This method makes the robot drive.
	// It takes four numbers, one for each motor,
	// starting in the back left and going clockwise
	public void drive(double backLeft, double frontLeft, double frontRight, double backRight) {
		motorBackLeft.setPower(backLeft);
		motorFrontLeft.setPower(frontLeft);
		motorFrontRight.setPower(frontRight);
		motorBackRight.setPower(backRight);
	}

	public void drive(double power) {
		drive(power, power, power, power);
	}

	public void driveForward(double power) {
		drive(power);
	}

	public void driveBackwards(double power) {
		drive(-1 * power);
	}

	public void stopDriving() {
		drive(0, 0, 0, 0);
	}

	public void strafeRight(double power) {
		drive(-1 * power, power, -1 * power, power);
	}

	public void strafeLeft(double power) {
		drive(power, -1 * power, power, -1 * power);
	}

	public void turnRight(double power) {
		drive(power, power, -1 * power, -1 * power);
	}

	public void turnLeft(double power) {
		drive(-1 * power, -1 * power, power, power);
	}


	@Override
	public void runOpMode() {
		setup();

		waitForStart();

		turnRight();
		sleep(250);
		driveForward();
		sleep(750);

		turnRight();
		sleep(250);
		driveForward();
		sleep(750);

		turnRight();
		sleep(250);
		driveForward();
		sleep(750);

		turnRight();
		sleep(250);
		driveForward();
		sleep(750);

	}
}