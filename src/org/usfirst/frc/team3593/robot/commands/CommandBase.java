package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;
import org.usfirst.frc.team3593.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CommandBase extends Command {
	
	public static boolean toggleForLifter = true;
	public static boolean previousVal = false;
	public static boolean setLifter = false;
	
	public static OI oi;
	public static I2C arduino = new I2C(I2C.Port.kOnboard, 4);
	
	//Subsystems
	public static DriveSubsystem theDriveSubsystem = new DriveSubsystem();
	public static IntakeSubsystem theIntakeSubsystem = new IntakeSubsystem();
	public static ShooterSubsystem theShooterSubsystem = new ShooterSubsystem();
	
	//Methods called in CommandBase
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
	
	public static void updateLEDs(String str) {
		char[] charArr = str.toCharArray();
		byte[] writeData = new byte[charArr.length];
		for (int i = 0; i<charArr.length; i++) {
			writeData[i] = (byte)charArr[i];
		}
		arduino.transaction(writeData, writeData.length, null, 0);
	}
}
