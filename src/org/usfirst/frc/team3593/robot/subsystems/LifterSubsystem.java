package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.*;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterSubsystem extends Subsystem {

	Solenoid lifter;
	
	public LifterSubsystem() {
		lifter = new Solenoid(RobotMap.lift);
	}
	
	public void setLifter(boolean setLifter) {
		if (lifter.get() != setLifter)
			lifter.set(setLifter);
			CommandBase.toggleLifter = setLifter;
			Robot.ntValues.getEntry("shooterPosition").setBoolean(setLifter);
	}
	
	public void lifterUp() {
		if (!lifter.get()) {
			lifter.set(true);
			CommandBase.toggleLifter = true;
			Robot.ntValues.getEntry("shooterPosition").setBoolean(true);
		}
	}
	
	public void lifterDown() {
		if (lifter.get())
		lifter.set(false);
		CommandBase.toggleLifter = false;
		Robot.ntValues.getEntry("shooterPosition").setBoolean(false);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

