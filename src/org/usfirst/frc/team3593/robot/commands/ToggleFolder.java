package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class ToggleFolder extends CommandBase {

	Boolean finish = false;
	
    public ToggleFolder() {
        requires(CommandBase.theFolder);
        requires(CommandBase.theFlap);
    }

    protected void initialize() {
    }

    protected void execute() {
    	CommandBase.toggleFolder = ! CommandBase.toggleFolder;
    	theFolder.folderCommand(toggleFolder);
    	if(toggleFolder = true) {
    		theFlap.flapUp();
    	}else if(toggleFolder = false) {
    		theFlap.flapDown();
    	}
    	Timer.delay(0.5);
    	finish = true;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
