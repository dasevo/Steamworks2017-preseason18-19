package org.usfirst.frc.team3630.robot.subsystems;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.commands.MecanumDrive_Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDrive_Subsystem extends Subsystem
{
	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new MecanumDrive_Command());
	}
	
	public void teleopDrive(double xAxis, double yAxis)
	{
			Robot.driveExecutor.setX(xAxis); 
			Robot.driveExecutor.setY(yAxis); 
	}
	
	public void teleopDrive(double xAxis, double yAxis, double zAxis) 
	//used in DriveToDistance and AutonomousDrive (can be deleted and substituted later)
	{
		Robot.driveExecutor.setX(xAxis);
		Robot.driveExecutor.setY(yAxis);
		Robot.driveExecutor.setZ(zAxis);
	}
}
