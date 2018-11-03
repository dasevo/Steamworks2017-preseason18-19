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
	public static Talon frontLeft = new Talon(3); //definition of talon for front left motor
	public static Talon frontRight = new Talon(1); //definition of talon for front right motor
	public static Talon backLeft = new Talon(2); //definition of talon for back left motor
	public static Talon backRight = new Talon(0); //definition of talon for back right motor
	public static Talon grabber = new Talon(4); //definition of talon for gear grabber
	public static Talon climber = new Talon(5);  //definition of talon for climber
	
	public static Encoder encoderLeft = new Encoder(0,1, false); //definition of left encoder
	public static Encoder encoderRight = new Encoder(2,3, false); //definition of right encoder
	
	public static DigitalInput autoGear = new DigitalInput(13); //definition of the limit switch for releasing the gear
	public static DigitalInput grabOpened = new DigitalInput(8); //definition of the limit switch for opening the gear grabber
	public static DigitalInput grabClosed = new DigitalInput(9); //definition of the limit switch for closing the gear grabber
}
