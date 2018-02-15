package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
	
	Spark shooterLRear;
	Spark shooterLFront;
	Spark shooterRRear;
	Spark shooterRFront;
	
	public ShooterSubsystem() {
		shooterLRear = new Spark(RobotMap.shooterLRear);
		shooterLFront = new Spark(RobotMap.shooterLFront);
		shooterRRear = new Spark(RobotMap.shooterRRear);
		shooterRFront = new Spark(RobotMap.shooterRFront);
	} 
	
	public void SetShooterSpeed(boolean lowTrig, boolean highTrig ) {
		if (lowTrig) {
			double speed = highTrig ? RobotMap.shooterHighSpeed: RobotMap.shooterLowSpeed;
			
			shooterRFront.set(speed);
			shooterLFront.set(speed);
			shooterRRear.set(speed);
			shooterLRear.set(speed);
		}
		else {
			shooterRFront.set(0);
			shooterLFront.set(0);
			shooterRRear.set(0);
			shooterLRear.set(0);
		}
	}
	
	
    public void initDefaultCommand() {
    
    }
}

