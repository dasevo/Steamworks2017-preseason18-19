package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MecanumDrive_Command extends Command
{
	
	public MecanumDrive_Command()
	{
		requires(Robot.mecanumDriveSubsystem);
	}
	
	@Override
	protected void initialize()
	{
		RobotMap.encoderLeft.reset();
		RobotMap.encoderRight.reset();
	}
	
	@Override
	protected void execute()
	{
		Robot.mecanumDriveSubsystem.teleopDrive(Robot.m_oi.getLeftX(), Robot.m_oi.getLeftY());
		//full speed, can be changed by multiplying
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	
	@Override
	protected void end() 
	{
		
	}
	
	@Override
	protected void interrupted()
	{
		
	}
}
