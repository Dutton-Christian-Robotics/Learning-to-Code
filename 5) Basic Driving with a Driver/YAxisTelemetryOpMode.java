package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "Y Axis Telemetry", group = "LearningJava")
public class YAxisTelemetryOpMode extends LinearOpMode {

    DryerRobot bot;

    @Override
    public void runOpMode() {
	   bot = new DryerRobot(hardwareMap);

	   waitForStart();
	   
	   while (opModeIsActive()) {
			 telemetry.addData("Y axis", gamepad1.left_stick_y);
			 telemetry.update();
		  }
	   }
    }
}
