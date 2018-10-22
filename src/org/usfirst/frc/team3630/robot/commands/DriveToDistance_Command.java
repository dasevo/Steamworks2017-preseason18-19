package org.usfirst.frc.team3630.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

public class DriveToDistance_Command extends Command
{
	private double distance;
	
	protected boolean isFinished()
	{
		if(Robot.driveExecutor.getY()==0)
		{
			return true; //if there is no movement (we are at the point where we want to be), end this command
		}
		else
			return false;
	}
	
	public DriveToDistance_Command()
	{
		requires(Robot.driveToDist);
	}
	
	public DriveToDistance_Command(double distance)
	{
		requires(Robot.driveToDist);
		this.distance = distance;
	}
	
	@Override
	protected void execute()
	{
		Robot.driveToDist.DriveToDistance(distance);
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
