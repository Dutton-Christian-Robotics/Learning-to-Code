package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "Distance Sensing, Random", group = "Learning")
public class DistanceSensingRandomOpMode extends LinearOpMode {


    @Override
    public void runOpMode() {
	   DryRobot bot = new DryRobot(hardwareMap);

	   waitForStart();

	   while (opModeIsActive()) {
		  telemetry.addData("Distance", "%.1f", bot.frontDistance.getDistance(DistanceUnit.INCH));
		  telemetry.update();
		  // How do we stop if we're too close?
//		  bot.driveForward();

		  if (bot.frontDistance.getDistance(DistanceUnit.INCH) <= 10) {
			  
			  
			   bot.stopDriving();
			   bot.driveBackward();
			   sleep(500);
		  
			   bot.turnRight();
			   int n = (int)(Math.random() * (1600 - 400) + 400);
			   sleep(n);
			   bot.stopDriving();
			   //requestOpModeStop();
		    } else {
			   bot.driveForward();
			   sleep(50);
			   //sleep(750);
		    }


	   }

    }
}