package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;



public class IntakeSubsystem extends Subsystem {

	Spark intakeL;
	Spark intakeR;
	Spark cimL;
	Spark cimR;
	
	Solenoid folders;
	
	
	public IntakeSubsystem() {
		
		intakeL = new Spark(RobotMap.intakeL);
		intakeR = new Spark(RobotMap.intakeR);
		cimL = new Spark(RobotMap.cimL);
		cimR = new Spark(RobotMap.cimR);
		
		folders = new Solenoid(RobotMap.folders);
		
	}
	
	public void takein(double takein) {
		intakeL.set(-takein);
		intakeR.set(takein);
	}
	
	public void takeout(double takeout) {
		intakeL.set(-takeout);
		intakeR.set(takeout);
	}
	
	public void ihavenoidea(double cimmi) {
		cimL.set(-cimmi);
		cimR.set(cimmi);
	}
	
	public void ihavenoidea2(double cimmi) {
		cimL.set(-cimmi);
		cimR.set(cimmi);
	}
	
	
	

    public void initDefaultCommand() {
    }
}

