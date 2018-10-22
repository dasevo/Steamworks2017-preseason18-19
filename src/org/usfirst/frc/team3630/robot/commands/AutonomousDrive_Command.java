package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDrive_Command extends Command
{
	
	private double speedX;
	private double speedY;
	private double speedZ;
	
	public AutonomousDrive_Command(double speedX, double speedY, double speedZ) //constructor that takes three parameters - speeds in different directions
	{
		requires(Robot.mecanumDriveSubsystem); //required subsystem
		this.speedX = speedX;
		this.speedY = speedY;
		this.speedZ = speedZ;
	}
	
	@Override
	protected boolean isFinished() //when returning true, end() is called
	{
		return false;
	}
	
	@Override
	protected void execute() //called until interrupted() or end() are called
	{
		Robot.mecanumDriveSubsystem.teleopDrive(speedX, speedY, speedZ); //sends values of x,y,z to the mecanumDrive_Subsystem
	}
	
	@Override
	protected void end() //called when isFinished returns true
	{
		Robot.mecanumDriveSubsystem.teleopDrive(0, 0, 0); //if end() is called, the motion is stopped in all directions
	}
	
	@Override
	protected void interrupted() //called when a command with same requirement starts
	{
		end(); //when interrupted, calls end()
	}
	
	@Override
	protected void initialize() //called when the command starts
	{
		
	}
}
