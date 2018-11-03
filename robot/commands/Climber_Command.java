package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climber_Command extends Command
{
	public Climber_Command()
	{
		requires(Robot.climber); //requires Climber_Subsystem
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	
	@Override
	protected void initialize() //called when the command is started
	{

	}
	
	@Override
	protected void end() //called when isFinished returns true
	{
		Robot.climber.setSpeed(0); //sets speed to 0
	}
	
	@Override
	protected void interrupted() //called when command with same requirement is started
	{
		end(); //calls end()
	}
	
	@Override
	protected void execute() //called until end() or interrupted() are called
	{
		Robot.climber.setSpeed(Robot.m_oi.getMecanumClimb());
	}
}
