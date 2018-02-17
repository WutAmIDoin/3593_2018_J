package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends CommandBase {
	

    public DriveCommand() {
    	requires(CommandBase.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	CommandBase.drive.driveTank(CommandBase.oi.XBC1.getRawAxis(1), CommandBase.oi.XBC1.getRawAxis(5));
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
