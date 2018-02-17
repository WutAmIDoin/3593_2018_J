package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlapSubsystem extends Subsystem {
	
	Solenoid flap;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public FlapSubsystem() {
		
		flap = new Solenoid(RobotMap.flap);
	}
	
	public void FlapThemFlaps(boolean FlapThemFlappers) {
		
		if(flap.get() != FlapThemFlappers) {
			flap.set(FlapThemFlappers);
			CommandBase.toggleFlap = FlapThemFlappers;
		}
		
		
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

