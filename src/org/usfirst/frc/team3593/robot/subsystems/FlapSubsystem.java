package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlapSubsystem extends Subsystem {
	Solenoid flap;
    
    public FlapSubsystem() {
    	flap = new Solenoid(RobotMap.flapSolenoidChannel);
    }
    
    public void setPosition(boolean setpoint) {
    	flap.set(setpoint);
    }
    
    public void setUp() {
    	flap.set(true);
    }
    
    public void setDown() {
    	flap.set(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

