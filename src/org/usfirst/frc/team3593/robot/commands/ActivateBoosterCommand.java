package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActivateBoosterCommand extends CommandBase {
	
	private boolean finished = false;
	
    public ActivateBoosterCommand() {
        super("ActivateBoosterCommand");
    	requires(CommandBase.theBoosterSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    
    //took out the CommandBase.
    protected void execute() {
    	theBoosterSubsystem.SetLauncher(true);
    	Timer.delay(1);
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	theBoosterSubsystem.SetLauncher(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
