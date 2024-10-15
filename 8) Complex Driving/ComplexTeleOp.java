package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Complex TeleOp", group = "TeleOp")
public class ComplexTeleOp extends LinearOpMode {

	ComplexDriveRobot bot;

	@Override
	public void runOpMode() {
		bot = new ComplexDriveRobot(hardwareMap);
		waitForStart();

		while (opModeIsActive()) {
			bot.drive(?, ?, ?);
		}

	}
}