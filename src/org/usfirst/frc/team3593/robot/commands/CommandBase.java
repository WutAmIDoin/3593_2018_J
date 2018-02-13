package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;
import org.usfirst.frc.team3593.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CommandBase extends Command {
	
	public static OI oi;
	public static I2C aruduino = new I2C(I2C.Port.kOnboard, 4);
	
	//Subsystems
	public static DriveSubsystem theDriveSubsystem = new DriveSubsystem();
	public static IntakeSubsystem theIntakeSubsystem = new IntakeSubsystem();
	
	
	//this is the methods called in robot.java
	public static void init() {
		oi = new OI();
	}
	
	

	public CommandBase() {
		super();
	}
	
	public CommandBase(String name) {
		super(name);
	}
	
	    // Make this return true when this Command no longer needs to run execute()
	@Override
    protected boolean isFinished() {
        return false;
    }
}
