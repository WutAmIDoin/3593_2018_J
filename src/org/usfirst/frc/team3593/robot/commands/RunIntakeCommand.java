package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunIntakeCommand extends CommandBase {

    public RunIntakeCommand() {
        requires(CommandBase.theIntakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1intakein) > .15) {
    		CommandBase.theIntakeSubsystem.runIntake(RobotMap.intakeIn);
    		theFlapSubsystem.flapDown();
    	}
    	else if (CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1intakein) > .15 && CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1intakeout) > .15) {
    		CommandBase.theIntakeSubsystem.runIntake(0);
    		theFlapSubsystem.flapUp();
    	}
    	else if (CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1intakeout) > .15) {
    		CommandBase.theIntakeSubsystem.runIntake(-CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1intakeout) * 0.8);
    		theFlapSubsystem.flapDown();
    	}
    	else {
    		CommandBase.theIntakeSubsystem.runIntake(0);
    		theFlapSubsystem.flapUp();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
