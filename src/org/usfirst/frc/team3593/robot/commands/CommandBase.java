package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.OI;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3593.robot.subsystems.*;

/**
 *
 */
public class CommandBase extends Command 
{
	public static OI oi;
	public static I2C arduino = new I2C(I2C.Port.kOnboard, 4);
	
	// Define all subsystems here
	public static DriveSubsystem drive = new DriveSubsystem();
	public static PowerSubsystem power = new PowerSubsystem();

	
	public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
    }
	
    public CommandBase() 
    {
        super();
    }
    
    public CommandBase(String name)
    {
    	super(name);
    }

	@Override
	protected boolean isFinished()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void UpdateLEDs(String str)
	{
		char[] charArr = str.toCharArray();
		byte[] WriteData = new byte[charArr.length];
		for (int i = 0; i < charArr.length; i++) {
			WriteData[i] = (byte) charArr[i];
		}
		arduino.transaction(WriteData, WriteData.length, null, 0);
	}
}
