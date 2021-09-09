package org.firstinspires.ftc.teamcode.dcs15815;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Complex Auto", group = "Autonomous")
public class ComplexAuto extends LinearOpMode {

    ComplexDriveRobot bot;

    @Override
    public void runOpMode() {
	   bot = new ComplexDriveRobot(hardwareMap);

	   waitForStart();

    }
}
