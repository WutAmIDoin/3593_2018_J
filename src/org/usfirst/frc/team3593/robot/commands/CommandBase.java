package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3593.robot.subsystems.*;

/**
 *
 */
public class CommandBase extends Command 
{
	public static OI oi;
	private static I2C arduino = new I2C(I2C.Port.kOnboard, 4);
	
	// NetworkTables
	public static NetworkTable ntValues;
	public static NetworkTable ntVision;
	public static NetworkTable ntBehav;
	
	// Define all subsystems here
	public static DriveSubsystem drive = new DriveSubsystem();
	public static FlapSubsystem flap = new FlapSubsystem();
	public static IntakeArms intakeArms = new IntakeArms();
	public static IntakeWheels intakeWheels = new IntakeWheels();
	public static LauncherSubsystem launcher = new LauncherSubsystem();
	public static LifterSubsystem lifter = new LifterSubsystem();
	public static NetworkSubsystem network = new NetworkSubsystem();
	public static PowerSubsystem power = new PowerSubsystem();
	public static SensorSubsystem sensors = new SensorSubsystem();
	public static ShifterSubsystem shifter = new ShifterSubsystem();
	public static ShooterWheels shooterWheels = new ShooterWheels();
	
	// Control values for commands
	public static boolean toggleShiftControl = false;
	public static boolean toggleLifterControl = false;
	public static boolean toggleIntakeArmsControl = false;
	public static boolean toggleFlapControl = false;

	
	public static void init() {
        // This MUST be here. OI only needs to be created once. 
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
		// TODO Auto-generated method stub
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
		for (int i = 0; i < charArr.length; i++) {
			WriteData[i] = (byte) charArr[i];
		}
		arduino.transaction(WriteData, WriteData.length, null, 0);
	}
}
