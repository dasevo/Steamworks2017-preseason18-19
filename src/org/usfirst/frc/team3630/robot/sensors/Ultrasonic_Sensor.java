package org.usfirst.frc.team3630.robot.sensors;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;

public class Ultrasonic_Sensor extends Robot
{
	Ultrasonic ultrasonic = new Ultrasonic(19,20);
	
	public Ultrasonic_Sensor()
	{
		ultrasonic.setAutomaticMode(true);
	}
	
	public double getDistanceIn() //must be multiplied by 2 all the time
	{
		return ultrasonic.getRangeInches();
	}
}
