package org.usfirst.frc.team3593.robot.commands;


public class ToggleShifter extends CommandBase {

	Boolean finish = false;
	
    public ToggleShifter() {
        requires(theShifter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	CommandBase.toggleShifter = ! CommandBase.toggleShifter;
    	CommandBase.theShifter.shifterCommand(toggleShifter);
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
