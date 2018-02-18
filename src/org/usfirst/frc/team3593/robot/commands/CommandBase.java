package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;
import org.usfirst.frc.team3593.robot.subsystems.BoosterSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.FlapSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.FolderSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.LifterSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.ShifterSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.*;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CommandBase extends Command {
	
	//Toggle Values
	public static boolean toggleLifter = false;
	public static boolean toggleShifters = false;
	public static boolean toggleFolders = false;
	public static boolean toggleFlap = false;
	
	//New OI and Lights
	public static OI oi;
	public static I2C arduino = new I2C(I2C.Port.kOnboard, 4);
	
	//Network Tables
	public static NetworkTable ntValues;
	public static NetworkTable ntVision;
	public static NetworkTable ntBehav;
	
	//Subsystems
	public static DriveSubsystem theDriveSubsystem = new DriveSubsystem();
	public static IntakeSubsystem theIntakeSubsystem = new IntakeSubsystem();
	public static ShooterSubsystem theShooterSubsystem = new ShooterSubsystem();
	public static BoosterSubsystem theBoosterSubsystem = new BoosterSubsystem();
	public static LifterSubsystem theLifterSubsystem = new LifterSubsystem();
	public static FolderSubsystem theFolderSubsystem = new FolderSubsystem();
	public static ShifterSubsystem theShifterSubsystem = new ShifterSubsystem();
	public static FlapSubsystem theFlapSubsystem = new FlapSubsystem();
	public static SensorSubsystem theSensorSubsystem = new SensorSubsystem();
	
	public static PowerSubsystem power = new PowerSubsystem();

	//Methods called in CommandBase
	public static void init() {
		oi = new OI();
		ntValues = NetworkTableInstance.getDefault().getTable("3593-Values");
		ntVision = NetworkTableInstance.getDefault().getTable("3593-Vision");
		ntBehav = NetworkTableInstance.getDefault().getTable("3593-Behavior");
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

	private static String upperControlString = "";
	private static String chassisControlString = "";
	
//	public static void UpdateUpperLEDs(String sendData) {
//		if(upperControlString != sendData) {
//			CommandBase.ArduinoTransact(sendData, chassisControlString);
//			upperControlString = sendData;
//		}
//	}
//	
//	public static void UpdateDriveLEDs(String sendData) {
//		if(chassisControlString != sendData) {
//			CommandBase.ArduinoTransact(upperControlString, sendData);
//			chassisControlString = sendData;
//		}
//	}
	
//	public static void ArduinoTransact(String shooterValue, String driveValue) {
//		String str = shooterValue + "-" + driveValue;
//		char[] charArr = str.toCharArray();
//		byte[] WriteData = new byte[charArr.length];
//		for (int i = 0; i < charArr.length; i++) {
//			WriteData[i] = (byte) charArr[i];
//		}
//		arduino.transaction(WriteData, WriteData.length, null, 0);
//	}
	public static void updateLEDs(String str) {
		char[] charArr = str.toCharArray();
		byte[] writeData = new byte[charArr.length];
		for (int i = 0; i<charArr.length; i++) {
			writeData[i] = (byte)charArr[i];
		}
		arduino.transaction(writeData, writeData.length, null, 0);
	}
}
