package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

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
    }
    
    public void shiftLow() {
    	solShifter.set(true);
    }
    
    public void shiftHigh() {
    	solShifter.set(false);
    }

	@Override
	protected void initDefaultCommand()
	{
		// not needed
	}
}

