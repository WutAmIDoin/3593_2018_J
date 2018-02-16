package org.usfirst.frc.team3593.robot.commands;


public class ToggleLifterPosition extends CommandBase {
	boolean finished = false;

    public ToggleLifterPosition() {
        requires(CommandBase.lifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lifter.setPosition(CommandBase.toggleLifterControl);
    	CommandBase.toggleLifterControl = !CommandBase.toggleLifterControl;
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
