package org.usfirst.frc.team3630.robot;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive_Executor 
{	
	private boolean safeMode = false;
	
	public Drive_Executor()
	{
		
	}

	public void setSafeMode(boolean safeMode)
	{
		this.safeMode = safeMode;
	}
	
	public boolean getSafeMode()
	{
		return safeMode;
	}
	
	private double x; 
	private double y; 
	private double z;
	
	public void setX(double x) 
	{
		this.x = x;
	}
	public void setY(double y) 
	{
		this.y = y;
	}
	public void setZ(double z) 
	{
		this.z = z;
	}
	
	private MecanumDrive robotDrive = new MecanumDrive(RobotMap.frontLeft, RobotMap.backLeft, RobotMap.frontRight, RobotMap.backRight);
	//private DifferentialDrive tankDrive = new DifferentialDrive(leftM, rightM); Can't be like this, causes shaking of the robot
	
	public void execute() 
	{
		if(safeMode)
		{
			robotDrive.driveCartesian(.3*x, -.3*y, .3*z);
		}
		else
		{
			robotDrive.driveCartesian(x, -y, z);
		}
	}
}
