package org.usfirst.frc.team3593.robot.commands;


public class SetFolder extends CommandBase {
	boolean finished = false;
	boolean setpoint;

    public SetFolder(boolean set) {
        requires(CommandBase.theFolder);
        setpoint = set;
    }

 
    protected void initialize() {
    }


    protected void execute() {
    	theFolder.folderCommand(setpoint);
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
