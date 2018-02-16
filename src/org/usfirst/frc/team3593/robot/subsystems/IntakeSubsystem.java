package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3593.robot.commands.IntakeCommand;


public class IntakeSubsystem extends Subsystem {

	Spark intakeL;
	Spark intakeR;
	Spark cimL;
	Spark cimR;	
	
	public IntakeSubsystem() {
		
		intakeL = new Spark(RobotMap.intakeL);
		intakeR = new Spark(RobotMap.intakeR);
		cimL = new Spark(RobotMap.cimL);
		cimR = new Spark(RobotMap.cimR);		
	}
	
	public void takein(double takein) {
		intakeL.set(-takein);
		intakeR.set(takein);
	}
	
	public void takeout(double takeout) {
		intakeL.set(-takeout);
		intakeR.set(takeout);
	}
	
	public void cimin(double cimmi) {
		cimL.set(-cimmi);
		cimR.set(cimmi);
	}
	
	public void cimout(double cimmi) {
		cimL.set(-cimmi);
		cimR.set(cimmi);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeCommand());
    }
}

