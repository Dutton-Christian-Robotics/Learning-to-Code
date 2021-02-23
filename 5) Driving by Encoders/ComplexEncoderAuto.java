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

    }
}