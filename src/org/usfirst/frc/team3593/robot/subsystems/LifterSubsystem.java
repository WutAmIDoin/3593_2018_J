package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

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
			lifter.set(setLifter);
		}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

