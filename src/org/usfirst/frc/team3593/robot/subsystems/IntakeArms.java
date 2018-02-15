package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeArms extends Subsystem {
    Solenoid arms;
    
    public IntakeArms() {
    	arms = new Solenoid(RobotMap.intakeArmsSolenoidChannel);
    }
    
    public void setPosition(boolean setpoint) {
    	arms.set(setpoint);
    }
    
    public void setIn() {
    	arms.set(true);
    }
    
    public void setOut() {
    	arms.set(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

