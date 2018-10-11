package org.usfirst.frc.team3630.robot.subsystems;

import org.usfirst.frc.team3630.robot.RobotMap;
import org.usfirst.frc.team3630.robot.commands.Climber_Command;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber_Subsystem extends Subsystem
{
	
	private Talon climb = RobotMap.climber;
	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new Climber_Command());
	}
	
	public void setSpeed(double speed)
	{
		climb.set(speed);
	}
	
}

