package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;
import org.usfirst.frc.team3630.robot.commands.Autonomous_Command;

import edu.wpi.first.wpilibj.command.Command;

public class GearGrab_Command extends Command
{
	private double speed;
	
	protected boolean isFinished()
	{
		return false;
	}
	
	public GearGrab_Command()
	{
		requires(Robot.grabber);
	}
	
	public GearGrab_Command(double speed)
	{
		requires(Robot.grabber);
		this.speed = speed;
	}
	
	@Override
	protected void initialize()
	{
	}
	
	@Override
	public void execute()
	{
		while(!RobotMap.autoGear.get()) //if the switch is pressed, release the gear - works in autonomous and in teleop
		{
			while(RobotMap.grabOpened.get())
			{
				Robot.grabber.setSpeed(1);
			}
		}
			if(RobotMap.grabClosed.get()&&Robot.m_oi.getGrabberSpeed()<=0)
			{
				RobotMap.grabber.setSpeed(Robot.m_oi.getGrabberSpeed());
			}
			else if(RobotMap.grabOpened.get()&&Robot.m_oi.getGrabberSpeed()>=0)
			{
				RobotMap.grabber.setSpeed(Robot.m_oi.getGrabberSpeed());
			}

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
