package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Basic Driver Controlled", group = "LearningJava")
public class BasicDriverControlledOpMode extends LinearOpMode {

	DryerRobot bot;

	@Override
	public void runOpMode() {
		bot = new DryerRobot(hardwareMap);
		waitForStart();
		
		// your code will go here
	}
}