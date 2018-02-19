package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;
import org.usfirst.frc.team3593.robot.subsystems.*;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;


public class CommandBase extends Command {
		
	// toggle booleans
	public static Boolean toggleFlap = false;
	public static Boolean toggleFolder = false;
	public static Boolean toggleShifter = false;
	public static Boolean toggleLifter = false;
	
	
	public static OI oi;
	public static I2C arduino = new I2C (I2C.Port.kOnboard, 4);
	// onboard is the port, 4 is the address
	
	
	// NetworkTables
	public static NetworkTable ntValues;
	public static NetworkTable ntVision;
	public static NetworkTable ntBehav;
	
	
	// subsystems
	public static DriveSubsystem theDrive = new DriveSubsystem();
	public static IntakeSubsystem theIntake = new IntakeSubsystem();
	public static ShooterSubsystem theShooter = new ShooterSubsystem();
	public static SensorSubsystem theSensor = new SensorSubsystem();
	public static PowerSubsystem thePower = new PowerSubsystem();
	public static CameraSubsystem theCamera = new CameraSubsystem();
	
	// booster is not a toggle
	public static BoosterSubsystem theBooster = new BoosterSubsystem();
	
	public static FlapSubsystem theFlap = new FlapSubsystem();
	public static LifterSubsystem theLifter = new LifterSubsystem();
	public static ShifterSubsystem theShifter = new ShifterSubsystem();
	public static FolderSubsystem theFolder = new FolderSubsystem();
		
	
	
	// always declaration before methods
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
        
    
    @Override
    protected boolean isFinished() {
        return false;
    }
    
    // Arduino updating
    private static String upperControlString = "";
    private static String chassisControlString = "";
    
    public static void UpdateUpperLEDs(String sendData) {
    	if(upperControlString != sendData) {
    		CommandBase.ArduinoTransact(sendData, chassisControlString);
    		upperControlString = sendData;
    	}
    }

	public static void UpdateDriveLEDs(String sendData) {
		if(chassisControlString != sendData) {
			CommandBase.ArduinoTransact(upperControlString, sendData);
			chassisControlString = sendData;
		}
	}

	public static void ArduinoTransact(String shooterValue, String driveValue) {
		String str = shooterValue + "-" + driveValue;
		char[] charArr = str.toCharArray();
		byte[] WriteData = new byte[charArr.length];
		for(int i = 0; 1 < charArr.length; i++) {
			WriteData[i] = (byte) charArr[i];
		}
		arduino.transaction(WriteData, WriteData.length, null, 0);
	}
	
}
