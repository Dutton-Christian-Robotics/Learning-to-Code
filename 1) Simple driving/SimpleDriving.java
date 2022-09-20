package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "Simple Driving", group = "Learning")
public class SimpleDrivingOpMode extends LinearOpMode {

	@Override
	public void runOpMode() {
		DcMotor motorBackLeft = hardwareMap.dcMotor.get("back_left_motor");

		waitForStart();
		
		motorBackLeft.setPower(1);
		sleep(3000);
	}
}
