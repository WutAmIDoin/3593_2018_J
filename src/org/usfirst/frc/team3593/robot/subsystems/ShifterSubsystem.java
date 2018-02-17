package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShifterSubsystem extends Subsystem {

    Solenoid shifter;
    
    public ShifterSubsystem() {
    	shifter = new Solenoid(RobotMap.shifters);
    }
    
    public void setShifters(boolean setShifter) {
    	if (shifter.get() != setShifter) {
    		shifter.set(setShifter);
    		CommandBase.toggleShifters = setShifter;
    	}
    }
    
    public void setLow() {
    	if (shifter.get()) {
    		shifter.set(false);
    		CommandBase.toggleShifters = false;
    	}
    }
    
    public void setHigh() {
    	if (!shifter.get()) {
    		shifter.set(true);
    		CommandBase.toggleShifters = true;
    	}
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

