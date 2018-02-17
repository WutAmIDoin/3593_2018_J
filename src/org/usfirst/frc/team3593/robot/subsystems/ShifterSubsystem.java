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
    	}else{		
    	}
    }

    public void initDefaultCommand() {        
    }
}

