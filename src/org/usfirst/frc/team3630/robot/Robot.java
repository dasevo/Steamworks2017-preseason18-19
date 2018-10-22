/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import org.usfirst.frc.team3630.robot.subsystems.MecanumDrive_Subsystem;
import org.usfirst.frc.team3630.robot.commands.Autonomous_Command;
import org.usfirst.frc.team3630.robot.subsystems.Climber_Subsystem;
import org.usfirst.frc.team3630.robot.subsystems.GearGrab_Subsystem;
import org.usfirst.frc.team3630.robot.subsystems.Rotate_Subsystem;
import org.usfirst.frc.team3630.robot.sensors.Ultrasonic_Sensor;
import org.usfirst.frc.team3630.robot.commands.GearGrab_Command;
import org.usfirst.frc.team3630.robot.commands.ControlledRotate_Command;
import org.usfirst.frc.team3630.robot.commands.DriveToDistance_Command;
import org.usfirst.frc.team3630.robot.subsystems.DriveToDistance_Subsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static MecanumDrive_Subsystem mecanumDriveSubsystem = new MecanumDrive_Subsystem();
	public static Climber_Subsystem climber = new Climber_Subsystem();
	public static GearGrab_Subsystem grabber = new GearGrab_Subsystem();
	public static Rotate_Subsystem gyroRotate = new Rotate_Subsystem();
	public static Ultrasonic_Sensor ultrasonic;
	public static GearGrab_Command grab = new GearGrab_Command();
	public static Command rotate = new ControlledRotate_Command();
	public static DriveToDistance_Command driveFar = new DriveToDistance_Command();
	public static DriveToDistance_Subsystem driveToDist = new DriveToDistance_Subsystem();
	//definition of used commands and subsystems
	
	public static OI m_oi;
	//definition of OI
	
	Joystick driveStick;
	//definition of joystick
	
	public static Drive_Executor driveExecutor = new Drive_Executor();
	//definition of driveExecutor
	
	Command m_autonomousCommand = new Autonomous_Command();
	//definition of used autonomous command
	
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	//definition of chooser (not used)
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() //starts once when the code is started
	{
		m_oi = new OI(); //further definition of OI
		
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", m_chooser);
		
		new Thread(() -> {
			UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture();
			camera1.setResolution(640, 480);
			camera1.setFPS(30);
			camera1.setExposureAuto();
			
			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Camera1", 640, 480); 
			//set up a new camera with this name in SmartDashboard (Veiw->Add->CameraServer Stream Viewer)
			
			Mat source = new Mat();
			Mat output = new Mat();
			
			while(!Thread.interrupted())
			{
				cvSink.grabFrame(source);
				Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2RGB);//this will show the video in black and white 
				outputStream.putFrame(output);
			}					
		}).start();//definition of camera, runs even when disabled
		
		driveStick = new Joystick(0); //further definition of joystick
		gyroRotate.gyroInit(); //initializing the gyro - in Rotate_Subsystem
		driveToDist.driveToDistInit(); //initializing the ultrasonic drive - in DriveToDistance_Subsystem
		ultrasonic = new Ultrasonic_Sensor(); //further definition of ultrasonic

	}
	
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() 
	{

	}

	@Override
	public void disabledPeriodic() //tasks that the robot does when disabled
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() //initialization of the autonomous code
	{
		//m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) //if we have any autonomous code, start it
		{
			m_autonomousCommand.start();
		}
		RobotMap.encoderLeft.reset(); //reset the values of the encoder
		RobotMap.encoderRight.reset(); //reset the values of the encoder
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() //runs the autonomous mode, repeating every 20ms
	{
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Encoder Left: ", RobotMap.encoderLeft.getRaw()); //putting the value of the left encoder to the smartDashboard
		SmartDashboard.putNumber("Encoder Right: ", RobotMap.encoderRight.getRaw()); //putting the value of the right encoder to the smartDashboard
		SmartDashboard.putNumber("Ultrasonic sensor", ultrasonic.getDistanceIn()); //putting the value of the ultrasonic sensor to the smartDashboard
		driveExecutor.execute(); //running the execute() method in driveExecutor
		grab.execute(); //running the execute() method in GearGrab_Command (should run without this but this is ensuring us that it is on)
	}

	@Override
	public void teleopInit() //initialization of the teleoperated code
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) //if we have any autonomous code, end it
		{
			m_autonomousCommand.cancel();
		}

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() //runs the teleOp part of the code, repeats every 20 ms
	{
		Scheduler.getInstance().run(); //has to be here, I think that this is looping the method
		SmartDashboard.putNumber("Encoder Left: ", RobotMap.encoderLeft.getRaw()); //putting the value of the left encoder to the SmartDashboard
		SmartDashboard.putNumber("Encoder Right: ", RobotMap.encoderRight.getRaw()); //putting the value of the right encoder to the smartDashboard
		SmartDashboard.putNumber("Ultrasonic sensor", ultrasonic.getDistanceIn()); //putting the value of the ultrasonic sensor to the smartDashboard
		driveExecutor.execute(); //running the execute method in driveExecutor
		grab.execute(); //running the execute() method in GearGrab_Command (should run without this but this is ensuring us that it is on)
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
