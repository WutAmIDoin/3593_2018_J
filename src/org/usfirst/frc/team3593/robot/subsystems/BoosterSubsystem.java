package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3593.robot.commands.BoosterCommand;


public class BoosterSubsystem extends Subsystem {

	Solenoid booster;
	
	public BoosterSubsystem() {
		booster = new Solenoid(RobotMap.booster);
	}
	
	public void BoosterCommand(boolean booster1) {
		booster.set(booster1);
		
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new BoosterCommand());
    }
}

