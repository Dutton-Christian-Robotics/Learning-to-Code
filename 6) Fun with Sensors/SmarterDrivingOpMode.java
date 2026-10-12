package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Smart Driving", group = "Learning")
public class SmartDrivingOpMode extends LinearOpMode {
	SmartRobot bot;

	@Override
	public void runOpMode() {
		bot = new SmartRobot(hardwareMap);

		waitForStart();

		while (opModeIsActive()) {

			bot.driveForward(0.5);
			sleep(1000);

			bot.turnLeftWithIMU(90, 0.1);

		}

	}

}