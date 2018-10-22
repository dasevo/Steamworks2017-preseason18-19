package org.usfirst.frc.team3630.robot.sensors;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;

public class Ultrasonic_Sensor extends Robot
{
	Ultrasonic ultrasonic = new Ultrasonic(19,20); //definition of the ultrasonic sensor - DIO ports on NavX are numbered differently
	
	public Ultrasonic_Sensor()
	{
		ultrasonic.setAutomaticMode(true); //I think that this means that it's updated automatically
	}
	
	public double getDistanceIn() //returns the distance from an object in In
	{
		return ultrasonic.getRangeInches();
	}
}
