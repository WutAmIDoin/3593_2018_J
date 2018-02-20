package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShifterSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Solenoid solShifter; 
	
	public ShifterSubsystem() {
		solShifter = new Solenoid(RobotMap.shifterSolendoidChannel);
	}
    
    public void shift(boolean setpoint) {
    	solShifter.set(setpoint);
    	Robot.ntValues.getEntry("driveShifter").setBoolean(setpoint);
    }
    
    public void shiftLow() {
    	solShifter.set(true);
    	Robot.ntValues.getEntry("driveShifter").setBoolean(true);
    }
    
    public void shiftHigh() {
    	solShifter.set(false);
    	Robot.ntValues.getEntry("driveShifter").setBoolean(false);
    }

	@Override
	protected void initDefaultCommand()
	{
		// not needed
	}
}

