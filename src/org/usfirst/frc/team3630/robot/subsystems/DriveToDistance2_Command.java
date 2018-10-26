package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.Constants;
import org.usfirst.frc.team3630.robot.Robot;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance2_Command extends Command
{
	private double distance;
	private double howFar;
	private boolean less;
//	private double angle;
//	private boolean turn;
	private boolean encoderOK;
	private boolean ultrasonicOK;
	private boolean allOK;
	
	@Override
	protected boolean isFinished()
	{
		if(allOK)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public DriveToDistance2_Command()
	{
		requires(Robot.mecanumDriveSubsystem);
	}
	
	public DriveToDistance2_Command(double distance)
	{
		requires(Robot.mecanumDriveSubsystem);
		this.distance = distance;
		initialize();
//		turn = false;
	}
	
	@Override
	protected void initialize()
	{
		resetEncoders();
		getHowFar();
		initMoreLess();
//		getAngle();
		encoderOK = false;
		ultrasonicOK = false;
		allOK = false;
	}
	
	@Override
	protected void execute()
	{
		checkDistanceEncoders();
		if(encoderOK)
		{
			Robot.mecanumDriveSubsystem.teleopDrive(0, 0, 0);
			isAllOK(); //if the encoders report correct distance, stop and check it with ultrasonic
		}
		else if(less)
		{
			Robot.mecanumDriveSubsystem.teleopDrive(0, -0.3, 0); //if the value is less than the position we want, drive forward
		}
		else
		{
			Robot.mecanumDriveSubsystem.teleopDrive(0, 0.3, 0); //if the value is more than the position we want, drive backward
		}
	}
	
	@Override
	protected void interrupted()
	{
		end();
	}
	
	@Override
	protected void end()
	{
		Robot.mecanumDriveSubsystem.teleopDrive(0, 0, 0);
	}
	
	protected void getHowFar()
	{
		howFar =  Robot.ultrasonic.getDistanceIn()-5; //sets the distance from an object, use encoders to recognize how far we traveled
	}
	
/*	protected void getAngle()
	{
		angle = Robot.gyroRotate.returnAngle();
	}
*/
	
	protected void initMoreLess()
	{
		if(howFar>distance)
			less = false;
		else if(howFar<distance)
			less = true;	
	}
	
	protected double calculations()
	{
		double oneRotation =  2*Math.PI*Constants.wheelRadius; //sets how far do we travel by one rotation of the wheel
		double rotations = encoderL()/Constants.ticksPerRotation; //rotations of the wheel done
		double distanceTraveled = oneRotation*rotations; //calculates the distance traveled
		return distanceTraveled;
	}
	
	protected void resetEncoders()
	{
		RobotMap.encoderLeft.reset();
		RobotMap.encoderRight.reset();
	}
	
	protected double encoderL()
	{
		return RobotMap.encoderLeft.getRaw();
	}
	
	protected double encoderR()
	{
		return RobotMap.encoderRight.getRaw();
	}
	
/*	protected void differenceEncoders()
	{
		if(RobotMap.encoderLeft.getRaw()>RobotMap.encoderRight.getRaw()+100) //adjust values
		{
			turn = true;
		}
		else if(RobotMap.encoderLeft.getRaw()<RobotMap.encoderRight.getRaw()-100)
		{
			turn = true;
		}
		else
			turn = false;
	} //test if working appropriately, if not, delete
*/
	
	protected void checkDistanceEncoders()
	{
		if(isInBounds(calculations(),true))
		{
			encoderOK = true;
		}
		else
		{
			encoderOK = false;
		}
	}
	
	protected void checkDistanceUltrasonic()
	{
		checkDistanceEncoders();
		if(encoderOK)
		{
			getHowFar();
			if(isInBounds(howFar,false))
			{
				ultrasonicOK = true;
			}
			else
				ultrasonicOK = false;
		}
		else
			ultrasonicOK = false;
	}
	
	protected boolean isInBounds(double input, boolean encoders)
	{
		if(input<distance+Constants.toleranceIn&&input>distance-Constants.toleranceIn)
		{
			return true;
		}
		else if(encoders)
		{
			if(input<distance-Constants.toleranceIn)
			{
				less = true;
			}
			else if(input>distance+Constants.toleranceIn)
			{
				less = false;
			}
			return false;
		}
		else
			return false;
	}
	
	protected void isAllOK()
	{
		checkDistanceEncoders();
		checkDistanceUltrasonic();
		if(Robot.ultrasonic.getDistanceIn()>=244&&encoderOK)
		{
			allOK = true;
		}
		else if(encoderOK&&ultrasonicOK)
		{
			allOK = true;
		}
		else
			allOK = false;
			initialize();
	}
}