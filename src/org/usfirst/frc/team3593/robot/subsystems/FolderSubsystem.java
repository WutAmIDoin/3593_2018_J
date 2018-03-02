package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.*;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

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
		if (folders.get() != setFolders) {
			folders.set(setFolders);
			CommandBase.toggleFolders = setFolders;
			 CommandBase.dashTable.put("intakeArms", setFolders);
		}
	}
	
	public void foldersOut() {
		if (!folders.get()) {
			folders.set(true);
			CommandBase.toggleFolders = true;
			 CommandBase.dashTable.put("intakeArms", true);

		}
	}
	
	public void foldersIn() {
		if (folders.get()) {
			folders.set(false);
			CommandBase.toggleFolders = false;
			 CommandBase.dashTable.put("intakeArms", false);

		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

