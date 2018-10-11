package org.usfirst.frc.team3630.robot.subsystems;

import org.usfirst.frc.team3630.robot.commands.Rotate_Command;
import org.usfirst.frc.team3630.robot.commands.ControlledRotate_Command;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;

import org.usfirst.frc.team3630.robot.Robot;

public class Rotate_Subsystem extends Subsystem implements PIDOutput
{
	private static boolean rotateToAngle;
	private static final double kI = 0;
	private static final double kP = 0.03; //might need adjustment
	private static final double kD = 0;
	private static final double kF = 0;
	private static final double kToleranceAngles = 2.0f;
	private static AHRS ahrs;
	private PIDController turnController;
	
	public void initDefaultCommand()
	{
		setDefaultCommand(new ControlledRotate_Command());
	}
	
	public void gyroInit()
	{
		ahrs = new AHRS(SPI.Port.kMXP);
		turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
		turnController.setInputRange(-180f, 180f);
		turnController.setOutputRange(-1, 1);
		turnController.setAbsoluteTolerance(kToleranceAngles);
		turnController.setContinuous(true);
		turnController.enable();
		addChild(ahrs);
	}
	
	public void controlledRotate(double speed)
	{
		rotateToAngle = false;
		Robot.driveExecutor.setZ(speed);
	}
	
	public void turnToAngle(double setPoint)
	{
		turnController.setSetpoint(setPoint);
		rotateToAngle = true;
	}

	@Override
	public void pidWrite(double output)
	{
		if(rotateToAngle)
		{
			Robot.driveExecutor.setZ(output*0.4);
		}
	}
}
