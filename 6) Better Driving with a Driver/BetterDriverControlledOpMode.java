package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Better Driver Controlled", group = "LearningJava")
public class BetterDriverControlledOpMode extends LinearOpMode {

	PowerRatioRobot bot;

	@Override
	public void runOpMode() {
		bot = new PowerRatioRobot(hardwareMap);
		waitForStart();

		while (opModeIsActive()) {
			if (gamepad1.left_stick_y < 0) {
				bot.driveForward(Math.abs(gamepad1.left_stick_y));

			} else if (gamepad1.left_stick_y > 0) {
				bot.driveBackward(gamepad1.left_stick_y);

			} else if (gamepad1.left_trigger > 0) {
				bot.strafeLeft(gamepad1.left_trigger);

			} else if (gamepad1.right_trigger > 0) {
				bot.strafeRight(gamepad1.right_trigger);

			} else if (gamepad1.right_stick_x > 0) {
				bot.turnRight(gamepad1.right_stick_x);
				
			} else if (gamepad1.right_stick_x < 0) {
				bot.turnLeft(Math.abs(gamepad1.right_stick_x));

			} else {
				bot.stopDriving();
			}

		}

	}
}