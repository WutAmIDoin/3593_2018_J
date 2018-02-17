package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
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

	public void SetShooterSpeed(double speed) {
		shooterFL.set(speed);
		shooterFR.set(speed);
		shooterRL.set(speed);
		shooterRR.set(speed);
		// logic has to be done within the command
	}
	
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterCommand() );
    }
}

