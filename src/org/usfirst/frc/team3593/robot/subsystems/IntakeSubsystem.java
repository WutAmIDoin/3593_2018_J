package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.RunIntakeCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	
	Spark intakeL;
	Spark intakeR;
	Spark ciminiL;
	Spark ciminiR;
	
	public IntakeSubsystem() {
		intakeL = new Spark(RobotMap.intakeL);
		intakeR = new Spark(RobotMap.intakeR);
		ciminiL = new Spark(RobotMap.ciminiL);
		ciminiR = new Spark(RobotMap.ciminiR);
	}
	
	public void runIntake(double douknowdawea) {
		intakeL.set(douknowdawea * 0.85);
		intakeR.set(-douknowdawea * 0.85);
		ciminiR.set(douknowdawea);
		ciminiL.set(-douknowdawea);
	}
	
	// Set a default command
    public void initDefaultCommand() {
    	setDefaultCommand(new RunIntakeCommand());
    }
}

