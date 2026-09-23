package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Simple Driving", group = "Learning")
public class SimpleDrivingOpMode extends LinearOpMode {

	@Override
	public void runOpMode() {
		DcMotor motorBackLeft = hardwareMap.dcMotor.get("back_left_motor");
		DcMotor motorFrontLeft = hardwareMap.dcMotor.get("front_left_motor");
		DcMotor motorFrontRight = hardwareMap.dcMotor.get("front_right_motor");
		DcMotor motorBackRight = hardwareMap.dcMotor.get("back_right_motor");
	
		motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
		motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);

		waitForStart();
		
		motorBackLeft.setPower(1);
		motorFrontLeft.setPower(1);
		motorFrontRight.setPower(1);
		motorBackRight.setPower(1);
		
		sleep(3000);
		
		motorBackLeft.setPower(0);
		motorFrontLeft.setPower(0);
		motorFrontRight.setPower(0);
		motorBackRight.setPower(0);

	   }
    }
}
