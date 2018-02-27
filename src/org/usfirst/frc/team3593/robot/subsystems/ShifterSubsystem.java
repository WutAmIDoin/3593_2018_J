package org.usfirst.frc.team3593.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3593.robot.*;
import org.usfirst.frc.team3593.robot.commands.CommandBase;


public class ShifterSubsystem extends Subsystem {

    Solenoid shifter;
    
    public ShifterSubsystem() {
    	shifter = new Solenoid(RobotMap.shifter); 
    }
    
    public void shifterCommand(Boolean setpoint) {
    	if(shifter.get() != setpoint) {
    		shifter.set(setpoint);
    		CommandBase.toggleFlap = setpoint;
    		Robot.ntValues.getEntry("driveShifter").setBoolean(setpoint);
    	}
    }
    
    public void setLow() {
    	if (shifter.get()) {
    		shifter.set(false);
    		CommandBase.toggleShifter = false;
    		Robot.ntValues.getEntry("driveShifter").setBoolean(true);
    	}
    }

    public void setHigh() {
    	if (!shifter.get()) {
    		shifter.set(true);
    		CommandBase.toggleShifter = true;
    		Robot.ntValues.getEntry("driveShifter").setBoolean(false);
    	}
    }

    public void initDefaultCommand() {        
    }
}

