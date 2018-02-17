package org.usfirst.frc.team3593.robot.subsystems;



import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FlapSubsystem extends Subsystem {

    Solenoid flap;
    
    public FlapSubsystem(){  	
    	flap = new Solenoid(RobotMap.flap);
    	
    }
    
    public void setPosition(boolean setpoint) {
    	if(flap.get() != setpoint) {
    		flap.set(setpoint);
    		CommandBase.toggleFlap = setpoint;
    	}else{		
    	}
    }
    
    public void initDefaultCommand() {
    }
}

