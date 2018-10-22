package org.usfirst.frc.team3630.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3630.robot.RobotMap;
import org.usfirst.frc.team3630.robot.commands.GearGrab_Command;

public class GearGrab_Subsystem extends Subsystem
{
	private Talon grab = RobotMap.grabber;
	
	protected void initDefaultCommand()
	{
		setDefaultCommand(new GearGrab_Command()); //setting default command that is executed all time
	} 
	
	public void setSpeed(double speed)
	{
		grab.set(speed); //run the grabber at given speed
	}
}
