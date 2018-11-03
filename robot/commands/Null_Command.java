package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Null_Command extends Command
{
	public Null_Command()
	{
		
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	//This command is used to make breaks in autonomous (better for usage than AutonomousDrive(0,0,0))
}
