package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Rotate_Command extends Command
{
	private double angle;
	
	protected boolean isFinished()
	{
		if(Robot.driveExecutor.getZ()==0) //if the rotation is stopped, returns true
		{
			return true;
		}
		else
			return false;
	}
	
	public Rotate_Command(double angle)
	{
		requires(Robot.gyroRotate); //requires Rotate_Subsystem
		this.angle = angle;
	}
	
	@Override
	protected void initialize() //called when the command starts
	{
		
	}
	
	@Override
	protected void execute() //called until interrupted() or end() is called
	{
		Robot.gyroRotate.turnToAngle(angle); //sends an angle to the Rotate_Subsystem
	}
	
	@Override
	protected void interrupted() //called when a command with the same requirements is started
	{
		
	}
	
	@Override
	protected void end() //called when isFinished() returns true
	{
		
	}
}
