package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "Smarter Driving", group = "Learning")
public class SmarterDrivingOpMode extends LinearOpMode {
	SmarterRobot bot;

	@Override
	public void runOpMode() {
		bot = new SmarterRobot(hardwareMap);

		waitForStart();

		while (opModeIsActive()) {

			double p = Math.random();
			while (bot.frontDistance.getDistance(DistanceUnit.INCH) > 12) {
				bot.driveForward(p);
			}
			bot.driveBackwards(0.5);
			sleep(1000);

			double n = Math.random();

			if (n < 0.5 && bot.leftDistance.getDistance(DistanceUnit.INCH) > 12) {
				bot.turnLeftWithIMU(90, 0.2);
			} else if (n > 0.5 && bot.rightDistance.getDistance(DistanceUnit.INCH) > 12) {
				bot.turnRightWithIMU(90, 0.2);
			}

		}

	}

}