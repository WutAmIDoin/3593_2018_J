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
			 CommandBase.dashTable.put("shooterPosition", setLifter);
	}
	
	public void lifterUp() {
		if (!lifter.get()) {
			lifter.set(true);
			CommandBase.toggleLifter = true;
			CommandBase.dashTable.put("shooterPosition", true);
		}
	}
	
	public void lifterDown() {
		if (lifter.get())
		lifter.set(false);
		CommandBase.toggleLifter = false;
		CommandBase.dashTable.put("shooterPosition", false);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

