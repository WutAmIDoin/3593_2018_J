package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;


public class TakeOutCommand extends CommandBase {

    public TakeOutCommand() {
        requires(theIntake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	CommandBase.theIntake.takeout(RobotMap.takeOut);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
