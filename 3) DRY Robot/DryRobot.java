package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DryRobot {
    HardwareMap hwMap;
    DcMotor motorBackLeft;
    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackRight;
    DistanceSensor frontDistance;
    DistanceSensor rightDistance;


    DryRobot(HardwareMap hm) {
	   hwMap = hm;
	   motorBackLeft = hwMap.dcMotor.get("back_left_motor");
	   motorFrontLeft = hwMap.dcMotor.get("front_left_motor");
	   motorFrontRight = hwMap.dcMotor.get("front_right_motor");
	   motorBackRight = hwMap.dcMotor.get("back_right_motor");

	   motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
	   motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);

	   frontDistance = hwMap.get(DistanceSensor.class, "front_distance");
	   rightDistance = hwMap.get(DistanceSensor.class, "right_distance");
	   // Your turn: code the other two distance sensors
    }

    public void driveForward() {
	   motorBackLeft.setPower(1);
	   motorFrontLeft.setPower(1);
	   motorFrontRight.setPower(1);
	   motorBackRight.setPower(1);

    }

    public void driveBackward() {
	   motorBackLeft.setPower(-1);
	   motorFrontLeft.setPower(-1);
	   motorFrontRight.setPower(-1);
	   motorBackRight.setPower(-1);
    }


    public void stopDriving() {
	   motorBackLeft.setPower(0);
	   motorFrontLeft.setPower(0);
	   motorFrontRight.setPower(0);
	   motorBackRight.setPower(0);

    }

    public void turnLeft() {
	   motorBackLeft.setPower(-1);
	   motorFrontLeft.setPower(-1);
	   motorFrontRight.setPower(1);
	   motorBackRight.setPower(1);

    }

    public void turnRight() {
	   motorBackLeft.setPower(1);
	   motorFrontLeft.setPower(1);
	   motorFrontRight.setPower(-1);
	   motorBackRight.setPower(-1);
    }

    // add strafing methods here


    // In what ways could we make this code even DRYERer?


}
