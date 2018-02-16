package org.usfirst.frc.team3593.robot.commands;


public class ToggleFolder extends CommandBase {

	Boolean finish = false;
	
    public ToggleFolder() {
        requires(CommandBase.theFolder);
    }

    protected void initialize() {
    }

    protected void execute() {
    	CommandBase.toggleFolder = ! CommandBase.toggleFolder;
    	CommandBase.theFolder.folderCommand(toggleFolder);
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
