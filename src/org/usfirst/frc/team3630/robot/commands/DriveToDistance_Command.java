package org.usfirst.frc.team3630.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3630.robot.Robot;

public class DriveToDistance_Command extends Command
{
	private double distance;
	
	protected boolean isFinished()
	{
		return false;
	}
	
	public DriveToDistance_Command(double distance)
	{
		requires(Robot.mecanumDriveSubsystem);
		this.distance = distance;
	}
	
	@Override
	protected void execute()
	{
			while(Robot.ultrasonic.getDistanceIn()<distance)
			{
				Robot.mecanumDriveSubsystem.teleopDrive(0, -0.5, 0);
			}
			while(Robot.ultrasonic.getDistanceIn()>distance)
			{
				Robot.mecanumDriveSubsystem.teleopDrive(0, 0.5, 0);
			}
	}
	
	@Override
	protected void interrupted()
	{
		end();
	}
	
	@Override
	protected void end()
	{
		Robot.mecanumDriveSubsystem.teleopDrive(0, 0, 0);
	}
}
