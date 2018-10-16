package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.OI;
import org.usfirst.frc.team3630.robot.subsystems.MecanumDrive_Subsystem;

import edu.wpi.first.wpilibj.command.Command;

public abstract class Command_Base extends Command {
	
	public static OI oi;
	public static MecanumDrive_Subsystem driveMecanum = new MecanumDrive_Subsystem();
	
	public static void init()
	{
		oi = new OI();
	}
	
	public Command_Base(String name) {
		super(name);
	}
	
	public Command_Base() {
		super();
	}
}