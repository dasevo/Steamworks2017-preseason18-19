package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDrive_Command extends Command
{
	
	private double speedX;
	private double speedY;
	private double speedZ;
	
	public AutonomousDrive_Command(double speedX, double speedY, double speedZ)
	{
		requires(Robot.mecanumDriveSubsystem);
		this.speedX = speedX;
		this.speedY = speedY;
		this.speedZ = speedZ;
	}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void execute()
	{
		Robot.mecanumDriveSubsystem.teleopDrive(speedX, -speedY, speedZ);
		//speedY is negative to fix an error in DriverStation
	}
	
	protected void end()
	{
		Robot.mecanumDriveSubsystem.teleopDrive(0, 0, 0);
		//if ended, motion is stopped
	}
	
	protected void interrupted()
	{
		Robot.mecanumDriveSubsystem.teleopDrive(0, 0, 0);
		//if interrupted, motion is stopped
	}
	
	protected void initialize()
	{
		RobotMap.encoderLeft.reset();
		RobotMap.encoderRight.reset();
	}
}
