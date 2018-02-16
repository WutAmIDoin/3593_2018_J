package org.usfirst.frc.team3593.robot.commands;


public class ToggleLifter extends CommandBase {

	Boolean finish = false;
	
    public ToggleLifter() {
        requires(CommandBase.theLifter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	CommandBase.toggleLifter = ! CommandBase.toggleLifter;
    	CommandBase.theLifter.lifterCommand(CommandBase.toggleLifter);
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
