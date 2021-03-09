package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.matrices.MatrixF;
import org.firstinspires.ftc.robotcore.external.matrices.GeneralMatrixF;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp(name = "CuriosityJrMkXXII", group = "CuriosityJunior")
public class ChallengeOpMode extends LinearOpMode {
    ComplexEncoderRobot bot;
    DistanceSensor frontDistanceSensor;
    public void DoTheLoop(){
				bot.drive(1, 0, 0);
			 sleep(4000);
			 bot.stopDriving();
			 sleep(500);
			 telemetry.addData("Heading", bot.getIntegratedHeading());
			 telemetry.addData("Distance", bot.distanceSensor.getDistance(DistanceUnit.CM));
			 telemetry.update();
			 bot.comeToHeading(89); 
    }
	   @Override
    public void runOpMode(){
	   bot = new ComplexEncoderRobot(hardwareMap,telemetry);

	   waitForStart();
	   boolean keepDriving = true;
	   while (opModeIsActive() && keepDriving) {
		  bot.drive(1, 0, 0);
		  sleep(4500);
		  bot.stopDriving();
		  sleep(1000);
		  bot.comeToHeading(89);
		  DoTheLoop();
		  DoTheLoop();
		  DoTheLoop();
		  DoTheLoop();
		  DoTheLoop();
		  bot.drive(0,0.5,0);
		  sleep(500);
		  DoTheLoop();
		  DoTheLoop();
		  DoTheLoop();
		  DoTheLoop();
		  DoTheLoop();
		  bot.comeToHeading(175);
		  bot.drive(1,0.5,0);
		  sleep(1000);
		  keepDriving = false;
		  //for (int counter=0; counter < 10; counter++){
			 //bot.drive(1, 0, 0);
			 //sleep(4000);
			 //bot.stopDriving();
			 //sleep(500);
			 //telemetry.addData("Heading", bot.getHeading());
			 //telemetry.update();
			 //bot.comeToHeading(90);
		  //}
	   }

    }
}