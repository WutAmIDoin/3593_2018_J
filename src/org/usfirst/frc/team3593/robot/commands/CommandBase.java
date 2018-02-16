package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;
import org.usfirst.frc.team3593.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.DriveSubsystem.*;
import org.usfirst.frc.team3593.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CommandBase extends Command {
public static OI oi;
public static I2C arduino = new I2C(I2C.Port. kOnboard, 4);
public static ShooterSubsystem shooter = new ShooterSubsystem();


/// subsystems
public static DriveSubsystem drive = new DriveSubsystem();
public static void init () {
	oi=new OI();

}

    public CommandBase() {
      
    	super();
    }
    public CommandBase(String name) {
    
    	super(name);
    }

	


    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    public static void UpdateLEDs(String str){
    	char [] charArr=str.toCharArray();
    	byte[]WriteData= new byte[charArr.length];
    	for(int i=0; i< charArr.length; i++)
    	{WriteData[i]= (byte) charArr[i];
    	}
    	
    	arduino.transaction(WriteData,WriteData.length,null,0);
    }
    // writing data to adruino
    // last two are are receiving
    
    
    
  
    	
    
    
    
    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
