package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class AutoCommand extends CommandBase {

	private boolean finished = false;
	
    public AutoCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(CommandBase.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.driveTank(0.5, 0.5);
    	Timer.delay(5);
    	drive.driveTank(0, 0);
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.driveTank(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
