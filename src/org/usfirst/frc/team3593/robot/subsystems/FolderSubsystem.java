package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class FolderSubsystem extends Subsystem {
	
	Solenoid folder;
	
	public FolderSubsystem() {
		folder = new Solenoid(RobotMap.folder);
	}
	
	public void folderCommand(boolean setpoint) {
		if(folder.get() != setpoint) {
    		folder.set(setpoint);
    		CommandBase.toggleFlap = setpoint;
    	}else{		
    	}
	}
	
	public void foldersOut() {
		if (!folder.get()) {
			folder.set(true);
			CommandBase.toggleFolder = true;
			CommandBase.ntValues.getEntry("intakeArms").setBoolean(true);
		}
	}	

	public void foldersIn() {
		if (folder.get()) {
			folder.set(false);
			CommandBase.toggleFolder = true;
			CommandBase.ntValues.getEntry("intakeArms").setBoolean(false);
		}
	}
	
    public void initDefaultCommand() {
    }
}

