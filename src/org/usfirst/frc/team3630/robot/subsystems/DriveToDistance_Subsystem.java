package org.usfirst.frc.team3630.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.commands.DriveToDistance_Command;
import org.usfirst.frc.team3630.robot.UltrasonicPIDSource;

public class DriveToDistance_Subsystem extends Subsystem implements PIDOutput
{
	private static boolean driveToDistance = false;
	private static double kP = 0.0;
	private static double kI = 0.03;
	private static double kD = 0.0;
	private static double kF = 0.0;
	private static double kToleranceIn = 2.0;
	private AHRS ahrs;
	private PIDController driveController;
	UltrasonicPIDSource ultrasonicPIDSource;
	
	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new DriveToDistance_Command());
	}
	
	public void driveToDistInit()
	{
		ultrasonicPIDSource = new UltrasonicPIDSource();
		driveController = new PIDController(kP, kI, kD, kF, ultrasonicPIDSource, this);
		driveController.setInputRange(-640, 640); //should be 244 but this is here to be easily replaced by encoders
		driveController.setAbsoluteTolerance(kToleranceIn);
		driveController.setContinuous(true);
		driveController.enable();
		addChild(ahrs);
	}
	
	public void ControlledDrive()
	{
		driveToDistance = false;
	}
	
	public void DriveToDistance(double setPoint)
	{
		driveController.setSetpoint(setPoint);
		driveToDistance = true;
	}
	
	@Override
	public void pidWrite(double output)
	{
		if(driveToDistance)
		{
			Robot.driveExecutor.setY(output*0.6);
		}
	}
}
