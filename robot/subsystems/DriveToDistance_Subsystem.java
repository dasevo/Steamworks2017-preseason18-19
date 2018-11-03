package org.usfirst.frc.team3630.robot.subsystems;

import org.usfirst.frc.team3630.robot.Constants;
import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;
import org.usfirst.frc.team3630.robot.commands.MecanumDrive_Command;
import org.usfirst.frc.team3630.robot.EncoderPIDSource;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToDistance_Subsystem extends Subsystem implements PIDOutput
{
	private static boolean driveToDist;
	public PIDController driveController;
	public EncoderPIDSource encoderSource;
	public boolean first;
	
	public void initDefaultCommand()
	{
		setDefaultCommand(new MecanumDrive_Command());
	}
	
	public void controllerInit()
	{
		encoderSource = new EncoderPIDSource();
		driveController = new PIDController(Constants.kPdist, Constants.kIdist, Constants.kDdist, Constants.kFdist, encoderSource, this);
		driveController.setInputRange(-250, 250);
		driveController.setOutputRange(-.6, .6);
		driveController.setAbsoluteTolerance(Constants.toleranceIn);
		driveController.setContinuous(true);
		driveController.enable();
		addChild(encoderSource);
	}
	
	public void controlledDrive(double speedX, double speedY)
	{
		driveToDist = false;
		Robot.driveExecutor.setX(speedX);
		Robot.driveExecutor.setY(speedY);
	}
	
	public void driveToDistance(double setpoint)
	{
		driveController.setSetpoint(setpoint);
		driveToDist = true;
		SmartDashboard.putNumber("calculations", encoderSource.pidGet());
	}
	
	@Override
	public void pidWrite(double output)
	{
		if(driveToDist)
		{
			Robot.driveExecutor.setY(output*.6);
		}
	}
}
