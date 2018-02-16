package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShifterSubsystem extends Subsystem {
	
	Solenoid Shifter;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ShifterSubsystem() {
		Shifter = new Solenoid(RobotMap.shifter);
	}
	
	public void ShifterDoneShift(boolean ShiftyShadesOfGrey) {
		
		Shifter.set(ShiftyShadesOfGrey);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

