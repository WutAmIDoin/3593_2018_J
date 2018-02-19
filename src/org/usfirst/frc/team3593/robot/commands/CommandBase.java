package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;
import org.usfirst.frc.team3593.robot.subsystems.*;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;


public class CommandBase extends Command {
public static OI oi;
public static I2C arduino = new I2C(I2C.Port. kOnboard, 4);

public static NetworkTable ntValues; 
public static NetworkTable ntVision; 
public static NetworkTable ntBehav; 


//Define all subsystems here

public static DriveSubsystem drive = new DriveSubsystem();
public static FlapSubsystem flap = new FlapSubsystem();
public static IntakeArmSubsystem intakeArms = new IntakeArmSubsystem();
public static IntakeSubsystem intakeWheels = new IntakeSubsystem();
public static ShooterSubsystem shooter = new ShooterSubsystem();
public static LifterSubsystem lifter = new LifterSubsystem();
public static NetworkSubsystem network = new NetworkSubsystem();
public static PowerSubsystem power = new PowerSubsystem();
public static SensorSubsystem sensors = new SensorSubsystem();
public static ShifterSubsystem shifter = new ShifterSubsystem();
public static ShooterWheels shooterWheels = new ShooterWheels();
public static CameraSubsystem camera = new CameraSubsystem();
//Control values for commands
public static boolean toggleShiftControl = false;
public static boolean toggleLifterControl = false;
public static boolean toggleIntakeArmsControl = false;
public static boolean toggleFlapControl = false;



public static void init(){
	oi=new OI();
	ntValues = NetworkTableInstance.getDefault().getTable("3593-Value");
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
 		// Never want to return true here 
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
 
