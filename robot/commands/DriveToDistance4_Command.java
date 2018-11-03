package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Constants;
import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToDistance4_Command extends Command
{
	private boolean fromWall;
	private double distance;
	private double toTravel;
	private boolean first;
	
	public DriveToDistance4_Command()
	{
		requires(Robot.driveToDistance);
	}
	public DriveToDistance4_Command(double distance)
	{
		requires(Robot.driveToDistance);
		this.distance = distance;
		first=true;
	}
	
	@Override
	protected boolean isFinished()
	{
		 if(Math.abs(Robot.driveToDistance.encoderSource.pidGet()-distance)<Constants.toleranceIn&&Robot.driveExecutor.getY()==0)
		 {
		 	return true;
		 }
		 else
		 	return false;
	}
	
	@Override
	protected void initialize()
	{
				
	}
	
	@Override
	protected void execute()
	{
		if(first)
		{
			first=false;
			getDifference();
		}
		SmartDashboard.putNumber("distance", distance);
		if(fromWall)
		{
			Robot.driveToDistance.driveToDistance(distance);
		}
		else
			Robot.driveToDistance.driveToDistance(distance);
	}
	
	@Override
	protected void interrupted()
	{
		end();
	}
	
	@Override
	protected void end()
	{
		Robot.driveToDistance.controlledDrive(0, 0);
	}
	
	protected void getDifference()
	{
		toTravel = distance-(Robot.ultrasonic.getDistanceIn()-Robot.initialDist);
		//defines how far we have to go to get to some distance from wall (saves us some math)
	}
}
