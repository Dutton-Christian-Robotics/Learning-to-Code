package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Driver Controlled", group = "LearningJava")
public class DriverControlled extends LinearOpMode {

    DrivableRobot bot;

    @Override
    public void runOpMode() {
	   bot = new DrivableRobot(hardwareMap);
	   waitForStart();

	   while (opModeIsActive()) {
		  if (gamepad1.left_stick_y < 0) {
			 bot.driveForward();
		  } else if (gamepad1.left_stick_y > 0) {
			 bot.driveBackward();
		  } else if (gamepad1.left_stick_x < 0) {
			 bot.slideLeft();
		  } else if (gamepad1.left_stick_x > 0) {
			 bot.slideRight();
		  } else if (gamepad1.dpad_left && gamepad1.dpad_up) {
			 bot.driveForwardLeft();
		  } else if (gamepad1.dpad_left) {
			 bot.slideLeft();
		  } else {
			 bot.stopDriving();
		  }

	   }

    }
}