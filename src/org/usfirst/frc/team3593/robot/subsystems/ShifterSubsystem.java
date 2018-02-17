package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

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
	
	public void ShifterDoneShift(boolean ShiftyTheBifty) {
		if(Shifter.get() != ShiftyTheBifty)
		Shifter.set(ShiftyTheBifty);
		CommandBase.toggleShifter = ShiftyTheBifty;
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

