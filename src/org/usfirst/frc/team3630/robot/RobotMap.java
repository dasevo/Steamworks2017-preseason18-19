/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	public static Talon frontLeft = new Talon(3);
	public static Talon frontRight = new Talon(1);
	public static Talon backLeft = new Talon(2);
	public static Talon backRight = new Talon(0);
	public static Talon grabber = new Talon(4);
	public static Talon climber = new Talon(5); 
	
	public static Encoder encoderLeft = new Encoder(0,1, false); 
	public static Encoder encoderRight = new Encoder(2,3, false);
	public static Encoder Grabber = new Encoder(11,12,false);
	
	public static DigitalInput autoGear = new DigitalInput(13);
	public static DigitalInput grabOpened = new DigitalInput(8);
	public static DigitalInput grabClosed = new DigitalInput(9);
	//DIO ports + reversed value (change to true when the encoder is showing "-" values while going forward
	//TODO try to measure how the multipliers work
	
}
