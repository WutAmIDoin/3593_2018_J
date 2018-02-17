package org.usfirst.frc.team3593.robot.commands;


public class SetShifter extends CommandBase {

	boolean finished = false;
	boolean setpoint;
	
    public SetShifter(boolean set) {
        requires(CommandBase.theShifter);
        setpoint = set;
    }


    protected void initialize() {
    }


    protected void execute() {
    	theShifter.shifterCommand(setpoint);
    	finished = true;
    }


    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }

    
    protected void interrupted() {
    }
}
