package org.usfirst.frc.team3593.robot.commands;

public class ToggleFlapPosition extends CommandBase {
	Boolean finished = false;

    public ToggleFlapPosition() {
    	requires(CommandBase.flap);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	flap.setPosition(CommandBase.toggleFlapControl);
    	CommandBase.toggleFlapControl = !CommandBase.toggleFlapControl;
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
