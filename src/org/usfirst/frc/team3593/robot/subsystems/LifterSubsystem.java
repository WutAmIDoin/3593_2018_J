package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterSubsystem extends Subsystem {
	
	Solenoid lift;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public LifterSubsystem() {
		
		lift = new Solenoid(RobotMap.lift);
		
	}
	
	public void LiftTheLifter(boolean LiftyShadesDarker) {
		if(lift.get() != LiftyShadesDarker) {
			lift.set(LiftyShadesDarker);
			CommandBase.toggleLifter = LiftyShadesDarker;
		}
		
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

