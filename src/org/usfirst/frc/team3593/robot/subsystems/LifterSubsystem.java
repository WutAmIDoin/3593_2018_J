package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class LifterSubsystem extends Subsystem {

	Solenoid lifter;
	
	public LifterSubsystem() {
		lifter = new Solenoid(RobotMap.lifter);
		
	}
	
	public void lifterCommand(boolean setpoint) {
		if(lifter.get() != setpoint) {
    		lifter.set(setpoint);
    		CommandBase.toggleFlap = setpoint;
    	}else{		
    	}
	}
	
    public void initDefaultCommand() {
    }
}

