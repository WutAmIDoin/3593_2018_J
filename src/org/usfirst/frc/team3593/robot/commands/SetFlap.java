package org.usfirst.frc.team3593.robot.commands;


public class SetFlap extends CommandBase {
	boolean finished = false;
	boolean setpoint;

    public SetFlap(boolean set) {
        requires(CommandBase.theFlap);
        setpoint = set;
    }


    protected void initialize() {
    }

 
    protected void execute() {
    	theFlap.setPosition(setpoint);
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
