package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Rotate_Command extends Command
{
	private double angle;
	protected boolean isFinished()
	{
		return false;
	}
	
	public Rotate_Command(double angle)
	{
		requires(Robot.gyroRotate);
		this.angle = angle;
	}
	
	@Override
	protected void initialize()
	{
		
	}
	
	@Override
	protected void execute()
	{
		Robot.gyroRotate.turnToAngle(angle);
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
