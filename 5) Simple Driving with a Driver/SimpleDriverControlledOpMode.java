package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Simple Driver Controlled", group = "LearningJava")
public class SimpleDriverControlledOpMode extends LinearOpMode {

	SimpleDrivableRobot bot;

	@Override
	public void runOpMode() {
		bot = new SimpleDrivableRobot(hardwareMap);
		waitForStart();

		while (opModeIsActive()) {
			if (gamepad1.left_stick_y < 0) {
				bot.driveForward();

			} else if (gamepad1.left_stick_y > 0) {
				bot.driveBackward();

			} else if (gamepad1.left_trigger > 0) {
				bot.strafeLeft();

			} else if (gamepad1.right_trigger > 0) {
				bot.strafeRight();

			} else if (gamepad1.right_stick_x > 0) {
				bot.turnRight();
				
			} else if (gamepad1.right_stick_x < 0) {
				bot.turnLeft();

			} else {
				bot.stopDriving();
			}
			// implement turning
		}

	}
}