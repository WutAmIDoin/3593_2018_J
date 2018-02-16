package org.usfirst.frc.team3593.robot.subsystems;



import org.usfirst.frc.team3593.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FlapSubsystem extends Subsystem {

    Solenoid flap;
    
    public FlapSubsystem(){
    	
    	flap = new Solenoid(RobotMap.flap);
    	
    }
    
    public void flapCommand(Boolean flap1) {
		flap.set(flap1);		
	}
    
    public void flapUp() {
    	flap.set(true);
    }
    
    public void flapDown() {
    	flap.set(false);
    }
    
    public void initDefaultCommand() {
    }
}

