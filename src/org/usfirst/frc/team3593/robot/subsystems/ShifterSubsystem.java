package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShifterSubsystem extends Subsystem {
Solenoid shifter;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

public ShifterSubsystem() {
	shifter = new Solenoid(RobotMap.shifterSolendoidChannel);
}
public void letsShift(boolean shiftWork) {
	shifter.set(shiftWork);
}
 public void shiftLow() {
	 shifter.set(true);
	
 }

 public void shiftHigh() {
	 shifter.set(false);
 }
 
 

public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

