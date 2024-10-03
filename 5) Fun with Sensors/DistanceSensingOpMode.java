package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "Distance Sensing", group = "Learning")
public class DistanceSensingOpMode extends LinearOpMode {


    @Override
    public void runOpMode() {
	   DryRobot bot = new DryRobot(hardwareMap);

	   waitForStart();

	   while (opModeIsActive()) {
		  telemetry.addData("Distance", "%.1f", bot.frontDistance.getDistance(DistanceUnit.INCH));
		  telemetry.update();
		  bot.driveForward();


	   }

    }
}