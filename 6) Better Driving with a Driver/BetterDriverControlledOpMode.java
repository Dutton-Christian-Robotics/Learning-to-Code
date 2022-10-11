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
			if () {
				
				//your code goes here

			} else {
				bot.stopDriving();
			}

		}

	}
}