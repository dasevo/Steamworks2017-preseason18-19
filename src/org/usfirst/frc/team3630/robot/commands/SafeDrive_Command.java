package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.commands.MecanumDrive_Command;

import edu.wpi.first.wpilibj.command.Command;

public class SafeDrive_Command extends Command
{	
	public SafeDrive_Command()
	{
		requires(Robot.mecanumDriveSubsystem); //requires mecanumDrive_Subsystem
	}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	@Override
	protected void initialize() //called when the command is started
	{
		Robot.driveExecutor.setSafeMode(true); //sets safeMode in driveExecutor to true
	}
	
	@Override
	protected void execute() //called until interrupted() or end() is called
	{
		Robot.driveToDist.ControlledDrive(); //sets driveToDistance to false
		Robot.mecanumDriveSubsystem.teleopDrive(Robot.m_oi.getLeftX(), Robot.m_oi.getLeftY(), Robot.m_oi.getTrigger()); //sends values of the x,y,z varibles to the subsystem
	}
	
	@Override
	protected void end() //called when isFinished() returns true
	{
		Robot.driveExecutor.setSafeMode(false); //sets the safeMode in driveExecutor class to false
	}
	
	@Override
	protected void interrupted() //called when command with the same requirement is started
	{
		end(); //calls end()
	}
}
