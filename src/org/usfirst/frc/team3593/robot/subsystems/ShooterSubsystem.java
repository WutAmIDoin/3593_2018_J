package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem{
	Solenoid booster; 
	 	 
	 	public ShooterSubsystem() { 
	 		booster = new Solenoid(RobotMap.launcherSolenoidChannel); 
	 	} 
	 	 
	 	public void setSolenoid(boolean setpoint) { 
	 		if(booster.get() != setpoint) 
	 			booster.set(setpoint); 
	 	} 
		
	     public void initDefaultCommand() { 
	        // Set the default command for a subsystem here. 
	         //setDefaultCommand(new MySpecialCommand()); 
	     } 
	 } 
	