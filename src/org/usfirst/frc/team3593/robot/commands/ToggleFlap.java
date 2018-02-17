package org.usfirst.frc.team3593.robot.commands;


public class ToggleFlap extends CommandBase {
	
	Boolean finish = false;

    public ToggleFlap() {
        requires(CommandBase.theFlap);
    }
    
    protected void initialize() {
    }

    
    protected void execute() {
    	CommandBase.toggleFlap = !CommandBase.toggleFlap;
    	CommandBase.theFlap.setPosition(CommandBase.toggleFlap);
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
