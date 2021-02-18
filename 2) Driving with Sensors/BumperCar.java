package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "Bumper Car", group = "LearningJava")
public class BumperCar extends LinearOpMode {

    DrivableRobot bot;
    DistanceSensor frontDistanceSensor;

    @Override
    public void runOpMode() {
	   bot = new DrivableRobot(hardwareMap);
	   frontDistanceSensor = hardwareMap.get(DistanceSensor.class, "front_distance");

	   waitForStart();
	   while (opModeIsActive()) {
		  bot.driveForward();
		  while ((frontDistanceSensor.getDistance(DistanceUnit.CM) > 10) && opModeIsActive()) {
			 sleep(100);
			 telemetry.addData("front distance", frontDistanceSensor.getDistance(DistanceUnit.CM));
			 telemetry.update();
		  }
		  bot.driveBackward();
		  sleep(150);
		  bot.turnRight();
		  sleep(827);
	   }
    }
}
