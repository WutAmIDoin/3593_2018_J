package org.usfirst.frc.team3593.robot.commands;

import org.json.JSONObject;
import org.usfirst.frc.team3593.robot.*;
import org.usfirst.frc.team3593.robot.subsystems.*;
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
	
	//TommiNET
	public static JSONObject dashTable = new JSONObject();

	//New OI and Lights
	public static OI oi;
	public static I2C arduino = new I2C(I2C.Port.kOnboard, 4);
	
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
		//OI
		oi = new OI();
		
		//toggles
		dashTable.put("intakeArms", false);
		dashTable.put("shooterPosition", false);
		dashTable.put("driveShifter", false);
		dashTable.put("flapPosition", false);
		
		//Sensors
		dashTable.put("driveLeftEncoder", 0);
		dashTable.put("driveRightEncoder", 0);
		dashTable.put("gyroAngle", 0);
		dashTable.put("systemPressure", 0);
		
		//Power
		dashTable.put("battVoltage", 0);
		// Get total current of the PDP
		dashTable.put("totalCurrent", 0);
		
		dashTable.put("driveRight1", 0);
		dashTable.put("driveRight2", 0);
		dashTable.put("driveLeft1", 0);
		dashTable.put("driveLeft2", 0);
		dashTable.put("shooterRight1", 0);
		dashTable.put("shooterRight2", 0);
		dashTable.put("shooterLeft1", 0);
		dashTable.put("shooterLeft2", 0);
		dashTable.put("IntakeLeft", 0);
		dashTable.put("IntakeRight", 0);
		dashTable.put("cimmy1", 0);
		dashTable.put("cimmy2", 0);
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
