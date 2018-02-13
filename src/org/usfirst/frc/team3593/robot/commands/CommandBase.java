package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;
import org.usfirst.frc.team3593.robot.subsystems.*;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;


public class CommandBase extends Command {

	public static OI oi;
	public static I2C arduino = new I2C (I2C.Port.kOnboard, 4);
	// onboard is the port, 4 is the address
	
	
	// subsystems
	public static DriveSubsystem drive = new DriveSubsystem();
	public static IntakeSubsystem intake = new IntakeSubsystem();
	public static ShooterSubsystem shooter = new ShooterSubsystem();
	public static FlapSubsystem flap = new FlapSubsystem();
	
	// always decloration before methods
	public static void init() {
    	oi = new OI();
    }
	
    public CommandBase() {
    	super();
    	// super means 
    	// ouractions extends commandbase extends command
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
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
    	// sending data to arduino
    	// last two are receiving 
    }
    
    
    

}
