package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.commands.MecanumDrive_Command;

import edu.wpi.first.wpilibj.command.Command;

public class SafeDrive_Command extends Command
{
	MecanumDrive_Command drive = new MecanumDrive_Command();
	
	public SafeDrive_Command()
	{
		requires(Robot.mecanumDriveSubsystem);
	}
	
	protected boolean isFinished()
	{
		return false;
		//I think I found the problem
	}
	
	@Override
	protected void initialize()
	{
		Robot.driveExecutor.setSafeMode(true);
	}
	
	@Override
	protected void execute()
	{
		Robot.mecanumDriveSubsystem.teleopDrive(Robot.m_oi.getLeftX(), Robot.m_oi.getLeftY(), Robot.m_oi.getTrigger());
		//if not working, try using variables in Robot class - can try setting opposite value of safe in the driveExecutor class (if interrupted() doesn't work)
	}
	
	@Override
	protected void end()
	{
		Robot.driveExecutor.setSafeMode(false);
	}
	//this should be called when isFinished returns true
	
	@Override
	protected void interrupted()
	{
		end();
	}
	//this should be called when another command with same requirements is called
}
//works in case that toggleWhenPressed calls end() or interrupted()
