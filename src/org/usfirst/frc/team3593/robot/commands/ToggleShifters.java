package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleShifters extends CommandBase {
	boolean finished = false;
	
    public ToggleShifters() {
        // Use requires() here to declare subsystem dependencies
        requires(CommandBase.shifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shifter.shift(CommandBase.toggleShiftControl);
    	CommandBase.toggleShiftControl = !CommandBase.toggleShiftControl;
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
