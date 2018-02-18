package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.ChargeShootersCommand;

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
	
	// Put the speed determination logic in the command. Change this to
	// only accept one argument, speed, then simply set the motor speeds
	public void SetShooterSpeed(double speed) {
		shooterRFront.set(-speed);
		shooterLFront.set(speed);
		shooterRRear.set(-speed);
		shooterLRear.set(speed);
	}
	
	public void stopShooters() {
		shooterRFront.set(0);
		shooterLFront.set(0);
		shooterRRear.set(0);
		shooterLRear.set(0);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new ChargeShootersCommand());
    }
}
