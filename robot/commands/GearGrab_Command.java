package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;
import org.usfirst.frc.team3630.robot.commands.Autonomous_Command;

import edu.wpi.first.wpilibj.command.Command;

public class GearGrab_Command extends Command
{
	private double speed; //might be used to close in autonomous
	
	protected boolean isFinished()
	{
		return false;
	}
	
	public GearGrab_Command()
	{
		requires(Robot.grabber); //requires GearGrab_Subsystem
	}
	
	public GearGrab_Command(double speed)
	{
		requires(Robot.grabber); //requires GearGrab_Subsystem
		this.speed = speed;
	}
	
	@Override
	protected void initialize() //called when the command starts
	{
	}
	
	@Override
	public void execute() //called until end() or interrupted() is called
	{
		while(!RobotMap.autoGear.get()) //if the switch is pressed, release the gear - works in autonomous and in teleop
		{
			while(RobotMap.grabOpened.get())
			{
				Robot.grabber.setSpeed(1); //while the limit switch is not triggered, it keeps opening -> outer switch is not working very much
			}
		}
		RobotMap.grabber.setSpeed(Robot.m_oi.getGrabberSpeed());
/*		if(RobotMap.grabClosed.get()&&Robot.m_oi.getGrabberSpeed()<=0)
		{
			RobotMap.grabber.setSpeed(Robot.m_oi.getGrabberSpeed()); //if the limit switch is pressed, the only possibility is to open the grabber
		}
		else if(RobotMap.grabOpened.get()&&Robot.m_oi.getGrabberSpeed()>=0)
		{
			RobotMap.grabber.setSpeed(Robot.m_oi.getGrabberSpeed()); //if the limit switch is pressed, the only possibility is to close the grabber
		}
*/
	}
	
	@Override
	protected void end() //called when isFinished returns true
	{
		RobotMap.grabber.setSpeed(0); //Sets the speed of the grabber to 0
	}
	
	@Override
	protected void interrupted() //called when a command with the same requirement starts
	{
		end(); //end() is called
	}
}
