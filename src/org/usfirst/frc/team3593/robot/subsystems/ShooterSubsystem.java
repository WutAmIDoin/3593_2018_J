package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;
import org.usfirst.frc.team3593.robot.commands.ShooterCommand;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


public class ShooterSubsystem extends Subsystem {

	Spark shooterFL;
	Spark shooterFR;
	Spark shooterRL;
	Spark shooterRR;

	public ShooterSubsystem() {
		shooterFL = new Spark(RobotMap.shooterFrontLeft);
		shooterFR = new Spark(RobotMap.shooterFrontRight);
		shooterRL = new Spark(RobotMap.shooterRearLeft);
		shooterRR = new Spark(RobotMap.shooterRearRight);	
	}

	public void SetShooterSpeed(double setSpeed) {
		shooterFL.set(setSpeed);
		shooterFR.set(-setSpeed);
		shooterRL.set(setSpeed);
		shooterRR.set(-setSpeed);
		String sendData = "";
		if(setSpeed > 0.9) {
			sendData = "FULL";
		}else if(setSpeed > 0.45) {
			sendData = "HALF";
		}else {
			sendData = "DEF";
		}
		CommandBase.UpdateUpperLEDs("IN" + sendData);
	}
	
	public void StopShooter() {
		shooterFL.set(0);
		shooterFR.set(0);
		shooterRL.set(0);
		shooterRR.set(0);
		CommandBase.UpdateUpperLEDs("SHOTDEF");
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterCommand() );
    }
}

