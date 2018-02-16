package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/** 
 *
 */
public class ShooterSubsystem extends Subsystem {
	
	Spark shooterFrontL;
	Spark shooterRearL;
	Spark shooterFrontR;
	Spark shooterRearR;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ShooterSubsystem() {
		shooterFrontL = new Spark(RobotMap.shooterFrontL);
		shooterRearL = new Spark(RobotMap.shooterRearL);
		shooterFrontR = new Spark(RobotMap.shooterFrontR);
		shooterRearR = new Spark(RobotMap.shooterRearR);
	}	
	
	
	public void SetSpeed(Boolean lowTrig, Boolean hightrig) {
		if(lowTrig) {
			double speed = hightrig? RobotMap.HighTrig: RobotMap.LowTrig;
			shooterFrontL.set(speed);
			shooterRearL.set(speed);
			shooterFrontR.set(-1 * speed);
			shooterRearR.set(-1 * speed);
		
		}else {
			shooterFrontL.set(0);
			shooterRearL.set(0);
			shooterFrontR.set(0);
			shooterRearR.set(0);
			
		}
	}
	
    public void initDefaultCommand() {
    	
   
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

