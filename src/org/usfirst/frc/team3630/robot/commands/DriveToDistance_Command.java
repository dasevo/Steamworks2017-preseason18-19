package org.usfirst.frc.team3630.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

public class DriveToDistance_Command extends Command
{
	private double distance;
	private double speed;
	
	protected boolean isFinished()
	{
//		if(speed<0)
//			return Robot.ultrasonic.getDistanceIn()-5>=distance; //if working poorly, set some deadzone, set the "zero" more accurate
		return deadZone();
	}
	
	public DriveToDistance_Command()
	{
		requires(Robot.mecanumDriveSubsystem);
	}
	
	public DriveToDistance_Command(double distance, double speed)
	{
		requires(Robot.mecanumDriveSubsystem);
		this.distance = distance;
		this.speed = speed;
	}
	
	public void setDistance(double distance)
	{
		this.distance = distance;
	}
	
	@Override
	protected void execute()
	{
		Robot.mecanumDriveSubsystem.teleopDrive(0, speed, 0);
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
	
	public boolean deadZone() //make it boolean
	{
		if(speed<0)
		{
			if(Robot.ultrasonic.getDistanceIn()>=distance||(RobotMap.encoderLeft.get()+RobotMap.encoderLeft.get())/1100>=distance)
			{
				return true;
			}	
		}
		else if(speed>0)
		{
			if(Robot.ultrasonic.getDistanceIn()<=distance||(RobotMap.encoderLeft.get()+RobotMap.encoderLeft.get())/1100<=distance)
			{
				return true;
			}
		}
			return false;
	}
}
