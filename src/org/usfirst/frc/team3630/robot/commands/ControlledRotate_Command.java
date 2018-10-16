package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ControlledRotate_Command extends Command
{
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	
	public ControlledRotate_Command()
	{
		requires(Robot.gyroRotate);
	}
	
	@Override
	protected void initialize() 
	{
		
	}
	
	@Override
	protected void execute()
	{
		Robot.gyroRotate.controlledRotate(Robot.m_oi.getTrigger());
	}
	
	@Override
	protected void interrupted()
	{
		
	}
	
	@Override
	protected void end()
	{
		
	}
}
