package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;



public class IntakeSubsystem extends Subsystem {

	Spark intakeFrontLeft;
	Spark intakeFrontRight;
	Spark intakeRearLeft;
	Spark intakeRearRight;
	
	Solenoid folders;
	
	
	public IntakeSubsystem() {
		
		intakeFrontLeft = new Spark(RobotMap.intakeFrontLeft);
		intakeFrontRight = new Spark(RobotMap.intakeFrontRight);
		intakeRearLeft = new Spark(RobotMap.intakeRearLeft);
		intakeRearLeft = new Spark(RobotMap.intakeRearRight);
		
		folders = new Solenoid(RobotMap.folders);
		
	}

    public void initDefaultCommand() {
    }
}

