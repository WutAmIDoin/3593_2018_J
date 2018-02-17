package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleFolderCommand extends CommandBase {
	
	private boolean finished = false;
    
	public ToggleFolderCommand() {
    requires(CommandBase.theFolderSubsystem);
    requires(CommandBase.theFlapSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	CommandBase.toggleFolders = !CommandBase.toggleFolders;
    	CommandBase.theFolderSubsystem.setFolders(CommandBase.toggleFolders);
    	
    	if (CommandBase.toggleFolders = true) {
    		CommandBase.theFlapSubsystem.flapUp();
    	}
    	
    	Timer.delay(.5);
    	
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
