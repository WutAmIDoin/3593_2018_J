package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team3593.robot.commands.CommandBase;
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
		intakeL.set(-setSpeed*0.8);
		intakeR.set(setSpeed*0.8);
		cimL.set(-setSpeed);
		cimR.set(setSpeed);
		String sendData = "";
		if(setSpeed > 0.9) {
			sendData = "FULL";
		}else if(setSpeed > 0.45) {
			sendData = "HALF";
		}else {
			sendData = "DEF";
		}
		//CommandBase.UpdateUpperLEDs("IN" + sendData);
	}
	
	public void stopIntake() {
		intakeL.set(0);
		intakeR.set(0);
		cimL.set(0);
		cimR.set(0);
		//CommandBase.UpdateUpperLEDs("INDEF");
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeCommand());
    }
}

