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
	
	public void setSolenoid(boolean setpoint) {
		if(booster.get() != setpoint)
			booster.set(setpoint);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new BoosterCommand());
    }
}

