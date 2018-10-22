package org.usfirst.frc.team3630.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

import org.usfirst.frc.team3630.robot.Constants;
import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.commands.DriveToDistance_Command;
import org.usfirst.frc.team3630.robot.UltrasonicPIDSource;

public class DriveToDistance_Subsystem extends Subsystem implements PIDOutput
{
	private static boolean driveToDistance = false;
	private PIDController driveController;
	UltrasonicPIDSource ultrasonicPIDSource;
	
	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new DriveToDistance_Command()); //default command that is executed at the first place
	}
	
	public void driveToDistInit()
	{
		ultrasonicPIDSource = new UltrasonicPIDSource(); //initialization of PID source
		driveController = new PIDController(Constants.kPdist, Constants.kIdist, Constants.kDdist, Constants.kFdist, ultrasonicPIDSource, this);//initialization of drive controller
		driveController.setInputRange(-640, 640); //should be 244 but this is here to be easily replaced by encoders
		driveController.setAbsoluteTolerance(Constants.kToleranceIn); //tolerance of In
		driveController.setContinuous(true); //
		driveController.enable(); //
	}
	
	public void ControlledDrive()
	{
		driveToDistance = false; //just to make sure that the pidWrite is not executing
	}
	
	public void DriveToDistance(double setPoint)
	{
		driveController.setSetpoint(setPoint); //sets the distance
		driveToDistance = true; //enables pidWrite execution
	}
	
	@Override
	public void pidWrite(double output)
	{
		if(driveToDistance) 
		{
			Robot.driveExecutor.setY(output*0.6); //set the speed to .6 of the input
		}
	}
}
