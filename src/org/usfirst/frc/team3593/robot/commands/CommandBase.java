package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;
import org.usfirst.frc.team3593.robot.subsystems.*;

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
	
	
	// subsystems
	public static DriveSubsystem theDrive = new DriveSubsystem();
	public static IntakeSubsystem theIntake = new IntakeSubsystem();
	public static ShooterSubsystem theShooter = new ShooterSubsystem();
	
	// booster is not a toggle
	public static BoosterSubsystem theBooster = new BoosterSubsystem();
	
	public static FlapSubsystem theFlap = new FlapSubsystem();
	public static LifterSubsystem theLifter = new LifterSubsystem();
	public static ShifterSubsystem theShifter = new ShifterSubsystem();
	public static FolderSubsystem theFolder = new FolderSubsystem();
		
	
	
	// always decloration before methods
	public static void init() {
    	oi = new OI();
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
    
    public static void UpdateLED(String str) {
    	char[] charArr = str.toCharArray();
    	byte[] writeData = new byte[charArr.length];
    	// byte = 8 bites, a bite is either 1 or 0;
    	for(int i = 0; i <charArr.length; i++) {
    		writeData[i] = (byte)charArr[i];
    	}
    	arduino.transaction(writeData, writeData.length, null, 0);
    	// sending data to arduinoz
    	// last two are receiving 
    }
    
    
    

}
