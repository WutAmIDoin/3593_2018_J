package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;


public class TakeInCommand extends CommandBase {

    public TakeInCommand() {
        requires(theIntake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	CommandBase.theIntake.takein(RobotMap.takeIn);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
