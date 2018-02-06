package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


public class ShooterSubsystem extends Subsystem {

	Spark shooterFrontLeft;
	Spark shooterFrontRight;
	Spark shooterRearLeft;
	Spark shooterRearRight;
	
	Solenoid booster;
	Solenoid lifter;
	
	public ShooterSubsystem() {
		
		shooterFrontLeft = new Spark(RobotMap.shooterFrontLeft);
		shooterFrontRight = new Spark(RobotMap.shooterFrontRight);
		shooterRearLeft = new Spark(RobotMap.shooterRearLeft);
		shooterRearRight = new Spark(RobotMap.shooterRearRight);
		
		booster = new Solenoid(RobotMap.booster);
		lifter = new Solenoid(RobotMap.lifter);		
	}
	
	
	public void liftCommand(boolean wat1) {
		lifter.set(wat1);
		
	}
    
	public void boosterCommand(boolean wat2) {
		booster.set(wat2);
		
	}
	
	
	public void SetSpeed(boolean lowTrig, boolean highTrig) {
		if(lowTrig) {
			double speed = highTrig? RobotMap.highTrig : RobotMap.lowTrig;
			shooterFrontLeft.set(speed);
			shooterFrontRight.set(1*speed);
			shooterRearLeft.set(speed);
			shooterRearRight.set(1*speed);
		}else {
			shooterFrontLeft.set(0);
			shooterFrontRight.set(0);
			shooterRearLeft.set(0);
			shooterRearRight.set(0);
		}
	}
	
	
    public void initDefaultCommand() {
    }
}

