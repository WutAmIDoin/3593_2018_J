package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

public class IntakeCommand extends CommandBase {

    public IntakeCommand() {
        requires(theIntake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1takein) > 0.15){
    		CommandBase.theIntake.takein(RobotMap.takeIn);
    	}else if(CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1takeout) > 0.15) {
    		CommandBase.theIntake.takeout(RobotMap.takeOut);
    	}else {
    		CommandBase.theIntake.takein(0);
    		CommandBase.theIntake.takeout(0);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
