package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetShifter extends CommandBase {
	boolean finished;
	boolean setShifter;
    public SetShifter(boolean setVal) {
        requires(CommandBase.theShifterSubsystem);
        setShifter = setVal;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	CommandBase.theShifterSubsystem.setShifters(setShifter);
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
