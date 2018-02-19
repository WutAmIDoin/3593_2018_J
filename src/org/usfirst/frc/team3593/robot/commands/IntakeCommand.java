package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

public class IntakeCommand extends CommandBase {

    public IntakeCommand() {
        requires(CommandBase.theIntake);
        requires(CommandBase.theFlap);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1takein) > .15) {
    		CommandBase.theIntake.setIntakeSpeed(RobotMap.takeIn);
    		theFlap.flapDown();
    	}
    	else if (CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1takein) > .15 && CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1takeout) > .15) {
    		CommandBase.theIntake.setIntakeSpeed(0);
    		theFlap.flapUp();
    	}
    	else if (CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1takeout) > .15) {
    		CommandBase.theIntake.setIntakeSpeed(-CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1takeout) * 0.8);
    		theFlap.flapDown();
    	}
    	else {
    		CommandBase.theIntake.stopIntake();
    		theFlap.flapUp();
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
