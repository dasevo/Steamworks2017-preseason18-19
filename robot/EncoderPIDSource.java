package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EncoderPIDSource implements PIDSource
{
	public EncoderPIDSource()
	{
		
	}
	
	public double pidGet()
	{
		double encoderL = RobotMap.encoderLeft.getRaw();
		double encoderR = RobotMap.encoderRight.getRaw();
		double positionIn = encoderL *(Math.PI *2*Constants.wheelRadius)/Constants.ticksPerRotation;
		return positionIn;
	}
	
	public PIDSourceType getPIDSourceType()
	{
		return PIDSourceType.kDisplacement;
	}
	
	public void setPIDSourceType(PIDSourceType toSet)
	{
		
	}
}
