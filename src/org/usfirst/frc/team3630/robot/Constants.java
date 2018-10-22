package org.usfirst.frc.team3630.robot;

public class Constants 
{
	//constants for DriveToDistance
	public static final double kPdist = 0.0; //constant P
	public static final double kIdist = 0.03; //constant I
	public static final double kDdist = 0.0; //constant D
	public static final double kFdist = 0.0; //constant F
	public static final double kToleranceIn = 2.0; //tolerance of inches
	
	
	//constants for Rotate
	public static final double kProt = 0.0; //constant P
	public static final double kIrot = 0.03; //constant I
	public static final double kDrot = 0.0; //constant D
	public static final double kFrot = 0.0; // constant F
	public static final double kTolerance = 2f; //tolerance of degrees
	
	//constants for OI
	
	final static int aButton = 1; //number of button A
	final static int bButton = 2; //number of button B
	final static int xButton = 3; //number of button X
	final static int yButton = 4; //number of button Y
	final static int leftBumper = 5; //number of left bumper
	final static int rightBumper = 6; //number of right bumper
	final static int backButton = 7; //number of button Back
	final static int startButton = 8; //number of button Start
	final static int lStickButton = 9; //number of left stick button
	final static int rStickButton = 10; //number of right stick button
	final static int lStickXAxis = 0; //number of axis of left stick in X direction
	final static int lStickYAxis = 1; //number of axis of left stick in Y direction
	final static int lTriggerAxis = 2; //number of axis of left trigger
	final static int rTriggerAxis = 3; //number of axis of right trigger
	final static int rStickXAxis = 4; //number of axis of right stick in X direction
	final static int rStickYAxis = 5; //number of axis of right stick in Y direction
	final static double deadzone = 0.15; //value of deadzone
	//numbering of buttons and sticks can be found on the Internet
}
