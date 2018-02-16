package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;
import org.usfirst.frc.team3593.robot.subsystems.*;
import org.usfirst.frc.team3593.*;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CommandBase extends Command {
	
	public static OI oi;
	public static I2C arduino = new I2C(I2C.Port.kOnboard, 4);
	
	//toggles
	
	public static boolean toggleShifter = false;
	public static boolean toggleFlap = false;
	public static boolean toggleFolder = false;
	public static boolean toggleLifter = false;
	                
	//subsystems
	
	public static DriveSubsystem drive = new DriveSubsystem();
	public static BoosterSubsystem booster = new BoosterSubsystem();
	public static FlapSubsystem flap = new FlapSubsystem();
	public static FolderSubsystem folder = new FolderSubsystem();
	public static IntakeSubsystem intake = new IntakeSubsystem();
	public static LifterSubsystem lifter = new LifterSubsystem();
	public static SensorSubsystem sensor = new SensorSubsystem();
	public static ShifterSubsystem shifter = new ShifterSubsystem();
	public static ShooterSubsystem shooter = new ShooterSubsystem();
	
	public static void init()
	{
		oi = new OI();
	}
    public CommandBase() {
    	
        super();
    }
	public CommandBase(String name) 
	{
		super(name);
	}

    @Override
    protected boolean isFinished() {
        return false;
    }
    
    public static void UpdateLEDs(String str)
    {
    	char[] charArr = str.toCharArray();
    	byte[] WriteData = new byte[charArr.length];
    	for(int i = 0; i < charArr.length;i++)
    	{
    		WriteData[i] = (byte) charArr[i];
    		arduino.transaction(WriteData, WriteData.length,null,0);
    }
    }
}
