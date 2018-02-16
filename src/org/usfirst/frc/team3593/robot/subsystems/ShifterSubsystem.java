package org.usfirst.frc.team3593.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3593.robot.*;


public class ShifterSubsystem extends Subsystem {

    Solenoid shifter;
    
    public ShifterSubsystem() {
    	shifter = new Solenoid(RobotMap.shifter); 
    }
    
    public void shifterCommand(Boolean shifter1) {
    	shifter.set(shifter1);
    }
    
    public void shifterHigh() {
    	shifter.set(true);
    }
    
    public void shifterLow() {
    	shifter.set(false);
    }

    public void initDefaultCommand() {        
    }
}

