package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

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
    	shifter.set(setShifter);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

