package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterSubsystem extends Subsystem {
	Solenoid lifter;
    
    public LifterSubsystem() {
    	lifter = new Solenoid(RobotMap.lifterSolenoidChannel);
    }
    
    public void setPosition(boolean setpoint) {
    	lifter.set(setpoint);
    	Robot.ntValues.getEntry("shooterPosition").setBoolean(setpoint);
    }
    
    public void setUp() {
    	lifter.set(true);
    	Robot.ntValues.getEntry("shooterPosition").setBoolean(true);
    }
    
    public void setDown() {
    	lifter.set(false);
    	Robot.ntValues.getEntry("shooterPosition").setBoolean(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

