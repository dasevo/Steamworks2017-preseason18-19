package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class UltrasonicPIDSource implements PIDSource
{
	public UltrasonicPIDSource()
	{
		
	}
	
	public double pidGet()
	{
		return Robot.ultrasonic.getDistanceIn()-5; //set the default distance more appropriately
	}
	
	public PIDSourceType getPIDSourceType()
	{
		return PIDSourceType.kDisplacement;
	}
	
	public void setPIDSourceType(PIDSourceType pidSource)
	{
		
	}
}
