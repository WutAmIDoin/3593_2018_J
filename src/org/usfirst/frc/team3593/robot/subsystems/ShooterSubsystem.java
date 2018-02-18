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
		shooterLRear = new Spark(RobotMap.shooterRearL);
		shooterLFront = new Spark(RobotMap.shooterFrontL);
		shooterRRear = new Spark(RobotMap.shooterRearR);
		shooterRFront = new Spark(RobotMap.shooterFrontR);
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

	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		
	}
}

