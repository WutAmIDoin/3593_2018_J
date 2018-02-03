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
	
	Solenoid lifter;
	Solenoid booster;
	
	public ShooterSubsystem() {
		shooterLRear = new Spark(RobotMap.shooterLRear);
		shooterLFront = new Spark(RobotMap.shooterLFront);
		shooterRRear = new Spark(RobotMap.shooterRRear);
		shooterRFront = new Spark(RobotMap.shooterRFront);
		
		lifter = new Solenoid(RobotMap.lift);
		booster = new Solenoid(RobotMap.booster);
	}
	
	public 
	
    public void initDefaultCommand() {
    
    }
}

