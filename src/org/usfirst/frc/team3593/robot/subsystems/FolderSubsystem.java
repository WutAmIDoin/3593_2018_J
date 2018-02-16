package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FolderSubsystem extends Subsystem {

	Solenoid folders;
	
	public FolderSubsystem() {
		folders = new Solenoid(RobotMap.folder);
	}
	
	public void setFolders(boolean setFolders) {
		folders.set(setFolders);
	}
	
	public void foldersOut() {
		folders.set(true);
	}
	
	public void foldersIn() {
		folders.set(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

