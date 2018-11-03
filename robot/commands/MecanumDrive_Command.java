package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MecanumDrive_Command extends Command
{
	
	public MecanumDrive_Command()
	{
		requires(Robot.driveToDistance); //requires mecanumDrive_Subsystem
	}
	
	@Override
	protected void initialize() //called when the command is started
	{
		RobotMap.encoderLeft.reset(); //resets the encoder
		RobotMap.encoderRight.reset(); //resets the encoder
	}
	
	@Override
	protected void execute() //called until end() or interrupted() is called
	{
		Robot.driveToDistance.controlledDrive(Robot.m_oi.getLeftX(), Robot.m_oi.getLeftY());
//		Robot.mecanumDriveSubsystem.teleopDrive(Robot.m_oi.getLeftX(), Robot.m_oi.getLeftY()); //sends the values of the left stick axis to the subsystem
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	
	@Override
	protected void end() //called when isFinished returns true 
	{
		Robot.driveToDistance.controlledDrive(0, 0);
	}
	
	@Override
	protected void interrupted() //called when a command with the same requirement is called
	{
		//if the motion was stopped here, the robot would stop every time, when SafeMode_Command is started -> same requirement
	}
}
