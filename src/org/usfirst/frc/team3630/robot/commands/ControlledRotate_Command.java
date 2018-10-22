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
		requires(Robot.gyroRotate); //requires Rotate_Subsystem
	}
	
	@Override
	protected void initialize() //called when the command is started
	{
		
	}
	
	@Override
	protected void execute() //called until interrupted() or end() is called
	{
		Robot.gyroRotate.controlledRotate(Robot.m_oi.getTrigger()); //assigns the speed of rotation
	}
	
	@Override
	protected void interrupted() //called when a command with same requirement is started
	{
		end(); //calls end()
	}
	
	@Override
	protected void end() //called when isFinished returns true
	{
		Robot.gyroRotate.controlledRotate(0); //sets the speed of rotation to 0
	}
}
