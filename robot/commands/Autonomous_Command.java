package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_Command extends CommandGroup //it is a mess for now, I will clear this later
{
	public Autonomous_Command()
	{
		double forwardSpeed = 0.3;
		double forwardTime = 1.36;
		//forwardSpeed = .3, forwardTime = 1.36 -> ~3ft; (try to redo with encoders for more accurate results)
		//2300 on encoders = 1m
		//before using driveToDistance, reset the encoders...
		double sideSpeed = 0.5;
		double sideTime = 1;
		//do some measurement
		double stopTime = 0.5; 
		//use with Null_Command

		/*addSequential(new AutonomousDrive_Command(0, forwardSpeed, 0), forwardTime*2); //6 ft forward
		addSequential(new AutonomousDrive_Command(0, 0, rotateSpeed), rotateTime/2); //rotate 45 degrees clockwise
		addSequential(new AutonomousDrive_Command(0, forwardSpeed, 0), forwardTime); //3ft forward
		addSequential(new AutonomousDrive_Command(sideSpeed, 0, 0), sideTime/2); //undefined (for now) side movement 
		addSequential(new AutonomousDrive_Command(0, 0, rotateSpeed), rotateTime/2.1); //rotate to full 90 degrees (to starting position)
		addSequential(new AutonomousDrive_Command(0, forwardSpeed, 0), (forwardTime*3+forwardTime/3)); //10 ft forward
		addSequential(new AutonomousDrive_Command(-sideSpeed, 0, 0), sideTime*2);
		addSequential(new AutonomousDrive_Command(0, 0, rotateSpeed), 2*rotateTime); //rotate 180 degrees
		addSequential(new AutonomousDrive_Command(0,-forwardSpeed, 0), forwardTime*2);
		addSequential(new AutonomousDrive_Command(0,-0.2,0),0.3);
		// make three repetitions - we have more other things to do, + if calculated correctly, three repetitions should be enough
		addSequential(new Null_Command(), 1);
		addSequential(new AutonomousDrive_Command(0, forwardSpeed, 0), forwardTime*2);*/
		
		//addSequential(new Rotate_Command(0f)); //SHOULD rotate by 45 degrees, after finishing starts next command - Actually, I have no  idea, what is going to happen
		
		RobotMap.encoderLeft.reset();
		RobotMap.encoderRight.reset();
		addSequential(new DriveToDistance4_Command(120));
		addSequential(new Rotate_Command(-90f));
		addSequential(new DriveToDistance4_Command(10));
		//reset the initial value of the "zero" of ultrasonic when the robot reaches 0
		
		
//		addSequential(new DriveToDistance2_Command(40));
//		addSequential(new Rotate_Command(90f));
//		addSequential(new Null_Command(),0.3);
//		addSequential(new DriveToDistance2_Command(70)); //double check
//		addSequential(new AutonomousDrive_Command(0, .4), 4);
	}
}
