package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

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
    	if(flap.get() != setpoint) {
    		flap.set(setpoint);
    		CommandBase.toggleFlapControl = setpoint;
    	}
    }
    
    public void setUp() {
    	if(!flap.get()) {
    		flap.set(true);
    		CommandBase.toggleFlapControl = true;
    	}
    }
    
    public void setDown() {
    	if(flap.get()) {
    		flap.set(false);
    		CommandBase.toggleFlapControl = false;
    	}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

