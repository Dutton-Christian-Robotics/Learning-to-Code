package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "DRY Driving", group = "Learning")
public class DryDrivingOpMode extends LinearOpMode {
	
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
	
	public void driveForward() {
		motorBackLeft.setPower(1);
		motorFrontLeft.setPower(1);
		motorFrontRight.setPower(1);
		motorBackRight.setPower(1);
	}
	
	public void driveBackward() {
	}
	
	public void turnRight() {
	}
	
	public void turnLeft() {
	}

	public void strafeRight() {
	}

	public void strafeLeft() {
	}

	
	public void stopDriving() {
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
}