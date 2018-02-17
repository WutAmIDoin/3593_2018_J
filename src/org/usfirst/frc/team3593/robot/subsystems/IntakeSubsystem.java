package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3593.robot.commands.IntakeCommand;


// need to make the whole setSpeed as one method.
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
	
	public void setIntakeSpeed(double setSpeed) {
		intakeL.set(-setSpeed);
		intakeR.set(setSpeed);
		cimL.set(-setSpeed);
		cimR.set(setSpeed);
	}
	
	public void stopIntake() {
		intakeL.set(0);
		intakeR.set(0);
		cimL.set(0);
		cimR.set(0);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeCommand());
    }
}

