package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "ComplexEncoder Auto", group = "Autonomous")
public class ComplexEncoderAuto extends LinearOpMode {

    ComplexEncoderRobot bot;

    @Override
    public void runOpMode() {
	   bot = new ComplexEncoderRobot(hardwareMap);

	   waitForStart();
	   // add your driving commands here
	  // bot.driveToPosition(x, y);
	//bot.comeToHeading(degrees);	  
bot.stopDriving();
   bot.driveToPosition(0, 0, -90);
   bot.stopDriving();
   bot.driveToPosition(91, 91);
   bot.stopDriving();
   sleep(1000);
   bot.driveToPosition(-91, 91);
   bot.stopDriving();
   sleep(1000);
   bot.driveToPosition(-91, -152);
   bot.stopDriving();
   sleep(500);
   bot.driveToPosition(-91, -31);
   bot.stopDriving();
   sleep(500);
   bot.driveToPosition(91, -31);
   bot.stopDriving();
   sleep(500);
   bot.driveToPosition(91,-152);
    }
}