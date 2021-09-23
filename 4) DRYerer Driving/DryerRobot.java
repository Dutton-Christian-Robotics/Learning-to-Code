package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DryerRobot {
	HardwareMap hwMap;
	DcMotor motorBackLeft;
	DcMotor motorFrontLeft;
	DcMotor motorFrontRight;
	DcMotor motorBackRight;


	DryerRobot(HardwareMap hm) {
		hwMap = hm;
		motorBackLeft = hardwareMap.dcMotor.get("back_left_motor");
		motorFrontLeft = hardwareMap.dcMotor.get("front_left_motor");
		motorFrontRight = hardwareMap.dcMotor.get("front_right_motor");
		motorBackRight = hardwareMap.dcMotor.get("back_right_motor");
		motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
		motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);

	}
	
	public void setPower(double bl, double fl, double fr, double br) {
		motorBackLeft.setPower(bl);
		motorFrontLeft.setPower(fl);
		motorFrontRight.setPower(fr);
		motorBackRight.setPower(br);		
	}

	public void driveForward() {
		setPower(1,1,1,1);
	}

	public void driveBackward() {
		setPower(-1,-1,-1,-1);
	}


	public void stopDriving() {
		setPower(0, 0, 0, 0);
	}
    
	public void turnLeft() {
		setPower(-1, -1, 1, 1);
	}
   
	public void turnRight() {
		setPower(1, 1, -1, -1);
	}

	public void strafeRight() {
		setPower(-1, 1, -1 , 1);
	}
	
	public void strafeLef() {
		setPower(1, -1, 1, -1);
	}



	// In what ways could we make this code even DRYERer?


}
