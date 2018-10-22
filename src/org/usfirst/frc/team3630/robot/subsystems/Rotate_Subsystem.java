package org.usfirst.frc.team3630.robot.subsystems;

import org.usfirst.frc.team3630.robot.commands.ControlledRotate_Command;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;

import org.usfirst.frc.team3630.robot.Constants;
import org.usfirst.frc.team3630.robot.Robot;

public class Rotate_Subsystem extends Subsystem implements PIDOutput
{
	private static boolean rotateToAngle;
	private static AHRS ahrs;
	private PIDController turnController;
	
	public void initDefaultCommand()
	{
		setDefaultCommand(new ControlledRotate_Command()); //sets default command that is executed at first
	}
	
	public void gyroInit()
	{
		ahrs = new AHRS(SPI.Port.kMXP); //definition of ahrs
		turnController = new PIDController(Constants.kProt, Constants.kIrot, Constants.kDrot, Constants.kFrot, ahrs, this); //definition of turnController
		turnController.setInputRange(-180f, 180f); //range of input (angles)
		turnController.setOutputRange(-1, 1); //range of output (speed)
		turnController.setAbsoluteTolerance(Constants.kTolerance); //tolerance of angles
		turnController.setContinuous(true); //
		turnController.enable(); //
		addChild(ahrs);
	}
	
	public void controlledRotate(double speed)
	{
		rotateToAngle = false; //disables autonomous turning
		Robot.driveExecutor.setZ(speed); //sets speed of rotation - used in Rotate_Command
	}
	
	public void turnToAngle(double setPoint)
	{
		turnController.setSetpoint(setPoint); //sets the angle to rotate to -> after some time, the starting angle starts drifting - reboot the robot
		rotateToAngle = true; //enables pidWrite
	}

	@Override
	public void pidWrite(double output)
	{
		if(rotateToAngle)
		{
			Robot.driveExecutor.setZ(output*0.6); //set the speed of the rotation to .6
		}
	}
}
