package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climber_Command extends Command
{
	public Climber_Command()
	{
		requires(Robot.climber);
	}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void initialize()
	{

	}
	
	protected void end()
	{

	}
	
	protected void interrupted()
	{
		end();
	}
	
	protected void execute()
	{
		Robot.climber.setSpeed(Robot.m_oi.getMecanumClimb()); // no safe mode needed
	}
}
