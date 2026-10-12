package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Encoder Auto", group = "Autonomous")
public class ComplexEncoderOpMode extends LinearOpMode {

	ComplexEncoderRobot bot;

	@Override
	public void runOpMode() {
		bot = new EncoderRobot(hardwareMap, telemetry);

		waitForStart();
		// add your driving commands here
	}
