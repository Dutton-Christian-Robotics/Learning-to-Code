package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class SmartRobot {
    HardwareMap hwMap;
    DcMotor motorBackLeft;
    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackRight;
    DistanceSensor frontDistance;
    DistanceSensor rightDistance;

    IMU imu;


    SmartRobot(HardwareMap hm) {
        hwMap = hm;
        motorBackLeft = hwMap.dcMotor.get("back_left_motor");
        motorFrontLeft = hwMap.dcMotor.get("front_left_motor");
        motorFrontRight = hwMap.dcMotor.get("front_right_motor");
        motorBackRight = hwMap.dcMotor.get("back_right_motor");

        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);

        frontDistance = hwMap.get(DistanceSensor.class, "front_distance");
//		backDistance = hwMap.get(DistanceSensor.class, "back_distance");

        imu = hwMap.get(IMU.class, "imu");

        imu.initialize(
               new IMU.Parameters(
                     new RevHubOrientationOnRobot(
                            RevHubOrientationOnRobot.LogoFacingDirection.UP,
                            RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                     )
               )
        );


    }

    // This method makes the robot drive.
    // It takes four numbers, one for each motor,
    // starting in the back left and going clockwise
    public void drive(double backLeft, double frontLeft, double frontRight, double backRight) {
        motorBackLeft.setPower(backLeft);
        motorFrontLeft.setPower(frontLeft);
        motorFrontRight.setPower(frontRight);
        motorBackRight.setPower(backRight);
    }

    public void drive(double power) {
        drive(power, power, power, power);
    }

    public void driveForward(double power) {
        drive(power);
    }

    public void driveBackwards(double power) {
        drive(-1 * power);
    }

    public void stopDriving() {
        drive(0, 0, 0, 0);
    }

    public void strafeRight(double power) {
        drive(-1 * power, power, -1 * power, power);
    }

    public void strafeLeft(double power) {
        drive(power, -1 * power, power, -1 * power);
    }

    public void turnRight(double power) {
        drive(power, power, -1 * power, -1 * power);
    }

    public void turnLeft(double power) {
        drive(-1 * power, -1 * power, power, power);
    }

    public void turnRightWithIMU(double angle, double power) {
        imu.resetYaw();
        while (angle >= 360) {
            angle -= 360;
        }
        if (angle >= 180) {
            turnLeftWithIMU(-1 * (angle - 360), power);
        } else {
            while (heading() < angle) {
                turnLeft(power);
            }
            stopDriving();
        }
    }

    public void turnLeftWithIMU(double angle, double power) {
        imu.resetYaw();
        while (angle >= 360) {
            angle -= 360;
        }
        if (angle >= 180) {
            turnRightWithIMU(-1 * (angle - 360), power);
        } else {
            while (heading() < angle) {
                turnLeft(power);
            }
            stopDriving();
        }
    }

    public YawPitchRollAngles robotOrientation() {
        return imu.getRobotYawPitchRollAngles();
    }

    public double heading() {
        return robotOrientation().getYaw(AngleUnit.DEGREES);
    }


}