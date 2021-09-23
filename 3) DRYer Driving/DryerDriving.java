package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "DRYer Driving", group = "Learning")
public class DryDrivingOpMode extends LinearOpMode {
	
	@Override
	public void runOpMode() {
		DryRobot bot = new DryRobot(hardwareMap);

		waitForStart();
		
		bot.driveForward();
		sleep(1000);

		bot.driveForward();
		sleep(1000);

		bot.driveBackward();		
		sleep(2000);

		bot.stopDriving();

	   }
    }
}
