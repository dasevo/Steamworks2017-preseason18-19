package org.usfirst.frc.team3630.robot;

public class Accelerate 
{
	public Accelerate()
	{
		
	}
	
	public double accelerate(double finalSpeed, double currentSpeed)
	{
		if(currentSpeed!=finalSpeed)
		{
			if(currentSpeed>finalSpeed)
			{
				return currentSpeed-Constants.accRatio;
			}
			else
				return currentSpeed+Constants.accRatio;
			//with ratio of .02, we can reach full speed in 1 s => is it high/low/enough?
		}
		else
		{
			return currentSpeed;
		}
	}
	//TODO add to subsystems rather than to commands
	//TODO think about the ideal distance when to start slowing down in autonomous - make some calculations
	
	public double teleopAccelerate(double currentSpeed, double joystickValue)
	{
		if(currentSpeed>joystickValue)
		{
			return currentSpeed-Constants.accRatioTeleop;
		}
		else if(currentSpeed<joystickValue)
		{
			return currentSpeed+Constants.accRatioTeleop;
		}
		else
		{
			return currentSpeed;
		}
	}
}
