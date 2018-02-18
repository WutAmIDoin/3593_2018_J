package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunIntakeCommand extends CommandBase {

    public RunIntakeCommand() {
    	
    	requires(CommandBase.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = 0;
    	if(CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1intakein) > .15) {
    		speed = RobotMap.intakeIn;
    	} else if(CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1intakeout) > .15) {
    		speed = RobotMap.intakeOut;
    	} else {
    		speed = 0;
    	}
    	
    	intake.intakeSetSpeed(speed);
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
