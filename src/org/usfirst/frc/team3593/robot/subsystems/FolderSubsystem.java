package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class FolderSubsystem extends Subsystem {
	
	Solenoid folder;
	
	public FolderSubsystem() {
		folder = new Solenoid(RobotMap.folder);
	}
	
	public void folderCommand(boolean fold1) {
		folder.set(fold1);
	}
	
	public void folderUp() {
		folder.set(true);
	}
	
	public void folderDown() {
		folder.set(false);
	}
	
    public void initDefaultCommand() {
    }
}

