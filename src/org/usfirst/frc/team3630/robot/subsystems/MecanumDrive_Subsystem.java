package org.usfirst.frc.team3630.robot.subsystems;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.commands.MecanumDrive_Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDrive_Subsystem extends Subsystem
{
	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new MecanumDrive_Command()); //sets default command that is executed at first
	}
	
	public void teleopDrive(double xAxis, double yAxis)
	{
			Robot.driveExecutor.setX(xAxis); //sets speed in x direction
			Robot.driveExecutor.setY(yAxis); //sets speed in y direction
	}
	
	public void teleopDrive(double xAxis, double yAxis, double zAxis) 
	//used in DriveToDistance and AutonomousDrive (can be deleted and substituted later)
	{
		Robot.driveExecutor.setX(xAxis); //sets speed in x direction
		Robot.driveExecutor.setY(yAxis); //sets speed in y direction
		Robot.driveExecutor.setZ(zAxis); //sets speed in z direction
	}
}
