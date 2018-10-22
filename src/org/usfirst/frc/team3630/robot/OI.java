/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc.team3630.robot.commands.MecanumDrive_Command;
import org.usfirst.frc.team3630.robot.commands.SafeDrive_Command;
import org.usfirst.frc.team3630.robot.commands.Climber_Command;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	XboxController controller = new XboxController(0);
	
	private final Button buttonA = new JoystickButton(controller, Constants.aButton);
	private final Button buttonB = new JoystickButton(controller, Constants.bButton);
	private final Button buttonX = new JoystickButton(controller, Constants.xButton);
	private final Button buttonY = new JoystickButton(controller, Constants.yButton);
	private final Button bumperL = new JoystickButton(controller, Constants.leftBumper);
	private final Button bumperR = new JoystickButton(controller, Constants.rightBumper);
	private final Button backB = new JoystickButton(controller, Constants.backButton);	
	private final Button startB = new JoystickButton(controller, Constants.startButton);
	private final Button leftStickB = new JoystickButton(controller, Constants.lStickButton);
	private final Button rightStickB = new JoystickButton(controller, Constants.rStickButton);
	//correct definition for xbox buttons
	
	public OI()
	{
		buttonA.toggleWhenPressed(new SafeDrive_Command()); //enables and disables safe mode (first press = on, second press = off)
	}
	
	public double deadzone(double input) //values between -deadzode and deadzone (+- .15) are ignored
	{
		if(Math.abs(input)>Constants.deadzone)
		{
			return input;
		}
		else
		{
			return 0.0;
		}
	}
	
	public double getLeftY() //returns value of axis of left stick in Y direction
	{
		return deadzone(controller.getY(Hand.kLeft));
	}
	
	public double getLeftX() //returns value of axis of left stick in X direction
	{
		return deadzone(controller.getX(Hand.kLeft));
	}
	
	public double getRightY() //returns value of axis of right stick in Y direction
	{
		return deadzone(controller.getY(Hand.kRight));
	}
	
	public double getRightX() //returns value of axis of right stick in X direction
	{
		return deadzone(controller.getX(Hand.kRight));
	}
	
	public double getTrigger() //returns value of axis of triggers
	{
		if(controller.getTriggerAxis(Hand.kRight)>0)
		{
			return deadzone(controller.getTriggerAxis(Hand.kRight));
		}
		else if(controller.getTriggerAxis(Hand.kLeft)>0)
		{
			return -deadzone(controller.getTriggerAxis(Hand.kLeft));
		}
		else
		{
			return 0.0;
		}
		//left trigger has negative value, right trigger has positive value
		
	}
	public double getMecanumClimb() //returns speed for the climber
	{
		return -Math.abs(getRightY());//the climber can go only forward (we can't burn the motor)
	}
	
	public double getGrabberSpeed() //returns speed for the gear grabber 
	{
		return getRightX();
	}
	
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
