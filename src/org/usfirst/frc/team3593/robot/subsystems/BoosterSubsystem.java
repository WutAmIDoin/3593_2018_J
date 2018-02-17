package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BoosterSubsystem extends Subsystem {
	
	Solenoid booster;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public BoosterSubsystem() {
		
		booster = new Solenoid(RobotMap.booster);
	}
	
	public void BoosterTheDoocher(boolean McBooster) {
		if(booster.get() != McBooster)
		 booster.set(McBooster);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

