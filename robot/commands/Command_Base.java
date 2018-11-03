package org.usfirst.frc.team3630.robot.commands;

import org.usfirst.frc.team3630.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public abstract class Command_Base extends Command {
	
	public static OI oi;
	
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