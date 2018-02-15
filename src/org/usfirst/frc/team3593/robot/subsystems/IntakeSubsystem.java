package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
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
	
	public void IntakeIn(double whoop) {
		intakeL.set(-whoop);
		intakeR.set(whoop);
		ciminiR.set(whoop);
		ciminiL.set(-whoop);
	}
	
	public void IntakeOut(double douknowdawea) {
		intakeL.set(douknowdawea);
		intakeR.set(-douknowdawea);
		ciminiR.set(-douknowdawea);
		ciminiL.set(douknowdawea);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

