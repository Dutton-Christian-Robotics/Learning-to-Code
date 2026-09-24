package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="Loopy DRY Driving", group="Learning") public class LoopyDryDrivingOpMode extends LinearOpMode {

	DcMotor motorBackLeft;
	DcMotor motorFrontLeft;
	DcMotor motorFrontRight;
	DcMotor motorBackRight;

	public void setup() {
		motorBackLeft=hardwareMap.dcMotor.get("back_left_motor");
		motorFrontLeft=hardwareMap.dcMotor.get("front_left_motor");
		motorFrontRight=hardwareMap.dcMotor.get("front_right_motor");
		motorBackRight=hardwareMap.dcMotor.get("back_right_motor");
		motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
		motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
	}

	public void driveForward() {
		motorBackLeft.setPower(1);
		motorFrontLeft.setPower(1);
		motorFrontRight.setPower(1);
		motorBackRight.setPower(1);
	}

	public void driveBackward() {
		motorBackLeft.setPower(-1);
		motorFrontLeft.setPower(-1);
		motorFrontRight.setPower(-1);
		motorBackRight.setPower(-1);
	}

	public void turnRight() {
		motorBackLeft.setPower(1);
		motorFrontLeft.setPower(1);
		motorFrontRight.setPower(-1);
		DcMotor motorBackLeft;
		DcMotor motorFrontLeft;
		DcMotor motorFrontRight;
		DcMotor motorBackRight;
	}

	public void setup() {
		motorBackLeft=hardwareMap.dcMotor.get("back_left_motor");
		motorFrontLeft=hardwareMap.dcMotor.get("front_left_motor");
		motorFrontRight=hardwareMap.dcMotor.get("front_right_motor");
		motorBackRight=hardwareMap.dcMotor.get("back_right_motor");

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

		for (int loopCount = 0; loopCount < 4; loopCount++) {
			turnRight();
			sleep(150);
			driveForward();
			sleep(200);
		}

		int loopCount = 0;
		while (loopCount < 4) {
			turnRight();
			sleep(150);
			driveForward();
			sleep(200);
			loopCount=loopCount + 1;
		}

		while (opModeIsActive()) {
			turnRight();
			sleep(150);
			driveForward();
			sleep(200);
		}


		int loopCount = 0;
		do {
			turnRight();
			sleep(150);
			driveForward();
			sleep(200);
			loopCount = loopCount + 1;
		} while (loopCount < 4);
		
		// If statements aren't traditionally thought of as a type of loop.
		// However, they do, "loop" a block of code either 0 or 1 times
		// In addition, they can define alternate conditions or "fallback" blocks
		// to execute if the original condition isn't met.
		if (opModeIsActive()) {
			turnRight();
			sleep(150);
			driveForward();
			sleep(200);
		
		} else if (motorBackLeft.isBusy()) {
			// This code will execute if the first condition is false but the
			// second condition is true.
			
		} else {
			// If neither of the other two conditions are true, this block executes
		}
		
	}




	}
}