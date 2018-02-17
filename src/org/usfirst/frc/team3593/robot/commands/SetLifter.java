package org.usfirst.frc.team3593.robot.commands;


public class SetLifter extends CommandBase {

	boolean finished = false;
	boolean setpoint;
	
    public SetLifter(boolean set) {
        requires(CommandBase.theLifter);
        setpoint = set;
    }


    protected void initialize() {
    }


    protected void execute() {
    	theLifter.lifterCommand(setpoint);
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
