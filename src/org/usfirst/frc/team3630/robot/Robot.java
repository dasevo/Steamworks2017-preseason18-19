/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team3630.robot.subsystems.MecanumDrive_Subsystem;
import org.usfirst.frc.team3630.robot.commands.Autonomous_Command;
import org.usfirst.frc.team3630.robot.subsystems.Climber_Subsystem;
import org.usfirst.frc.team3630.robot.subsystems.GearGrab_Subsystem;
import org.usfirst.frc.team3630.robot.subsystems.Rotate_Subsystem;
import org.usfirst.frc.team3630.robot.sensors.Ultrasonic_Sensor;
import org.usfirst.frc.team3630.robot.commands.GearGrab_Command;

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
	public static Ultrasonic_Sensor ultrasonic = new Ultrasonic_Sensor();
	public static GearGrab_Command grab = new GearGrab_Command();
	
	public static OI m_oi;
	Joystick driveStick;
	
	public static Drive_Executor driveExecutor = new Drive_Executor();
	
	Command m_autonomousCommand = new Autonomous_Command();
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		driveStick = new Joystick(0);
		gyroRotate.gyroInit();

	}
	
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
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
	public void autonomousInit() {
		//m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) 
		{
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Encoder Left: ", RobotMap.encoderLeft.getRaw());
		SmartDashboard.putNumber("Encoder Right: ", RobotMap.encoderRight.getRaw());
		SmartDashboard.putNumber("Ultrasonic sensor", ultrasonic.getDistanceIn());
		driveExecutor.execute();
		grab.execute();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Encoder Left: ", RobotMap.encoderLeft.getRaw());
		SmartDashboard.putNumber("Encoder Right: ", RobotMap.encoderRight.getRaw());
		SmartDashboard.putNumber("Ultrasonic sensor", ultrasonic.getDistanceIn());
		//SmartDashboard.putNumber("Encoder Left: ", RobotMap.encoderLeft.get());
		//SmartDashboard.putNumber("Encoder Right: ", RobotMap.encoderRight.get());
		driveExecutor.execute();
		grab.execute();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
