package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Drive_Executor 
{	
	private boolean safeMode = false; //safeMode enabled/disabled
	
	public Drive_Executor()
	{
		
	}

	public void setSafeMode(boolean safeMode) //set safeMode on/off
	{
		this.safeMode = safeMode;
	}
	
	public boolean getSafeMode() //return value of safeMode
	{
		return safeMode;
	}
	
	private double x; //speed sideways
	private double y; //speed forward
	private double z; //speed of rotation
	
	public void setX(double x) //set speed sideways
	{
		this.x = x;
	}
	public void setY(double y) //set speed forward
	{
		this.y = y;
	}
	public void setZ(double z) //set speed of rotation
	{
		this.z = z;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public double getZ()
	{
		return z;
	}
	
	
	private MecanumDrive robotDrive = new MecanumDrive(RobotMap.frontLeft, RobotMap.backLeft, RobotMap.frontRight, RobotMap.backRight);
	//definition of the type of driving + defining driving motor controllers (talons) for drive
	
	public void execute() //execution of this class
	{
		if(safeMode)
		{
			robotDrive.driveCartesian(.3*x, -.3*y, .3*z); //safeMode - the talons are outputting only 1/3 of the input (-.3 -> .3)
		}
		else
		{
			robotDrive.driveCartesian(x, -y, z); //normal drive, the talons are outputting the values that we input (-1 -> 1)
		}
	}
}
