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
	   motorBackRight.setPower(-1);
    }

    public void turnLeft() {
	   motorBackLeft.setPower(-1);
	   motorFrontLeft.setPower(-1);
	   motorFrontRight.setPower(1);
	   motorBackRight.setPower(1);
    }

    public void stopDriving() {
	   motorBackLeft.setPower(0);
	   motorFrontLeft.setPower(0);
	   motorFrontRight.setPower(0);
	   motorBackRight.setPower(0);
    }


    @Override
    public void runOpMode() {
	   setup();
	   waitForStart();

	   for (int loopCount = 0; loopCount < 10; loopCount++) {
		  turnRight();
		  sleep(150);
		  driveForward();
		  sleep(200);
	   }




	   int loopCount = 0;
	   while (loopCount < 3) {
		  turnRight();
		  sleep(150);
		  driveForward();
		  sleep(200);
		  loopCount = loopCount + 1;
	   }


	   int loopCount = 0;
	   do {
		  turnRight();
		  sleep(150);
		  driveForward();
		  sleep(200);
		  loopCount = loopCount + 1;
	   } while (loopCount < 3);


    }
}
