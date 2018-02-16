package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class LifterSubsystem extends Subsystem {

	Solenoid lifter;
	
	public LifterSubsystem() {
		lifter = new Solenoid(RobotMap.lifter);
		
	}
	
	public void lifterCommand(boolean lifter1) {
		lifter.set(lifter1);
		
	}

	public void lifterUp() {
		lifter.set(true);
	}
	
	public void lifterDown() {
		lifter.set(false);
	}
	
    public void initDefaultCommand() {
    }
}

