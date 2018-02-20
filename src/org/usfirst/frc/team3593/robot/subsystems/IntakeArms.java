package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.*;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

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
    	if(arms.get() != setpoint) {
    		arms.set(setpoint);
    		Robot.ntValues.getEntry("intakeArms").setBoolean(setpoint);
    	}
    }
    
    public void setIn() {
    	if(!arms.get()) 
    		arms.set(true);
    	Robot.ntValues.getEntry("intakeArms").setBoolean(true);
    }
    
    public void setOut() {
    	if(arms.get())
    		arms.set(false);
    	Robot.ntValues.getEntry("intakeArms").setBoolean(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

