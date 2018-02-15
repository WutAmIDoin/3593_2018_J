package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChargeShootersCommand extends CommandBase {

    public ChargeShootersCommand() {
        requires(CommandBase.theShooterSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	CommandBase.theShooterSubsystem.SetShooterSpeed(CommandBase.oi.XBC2.getRawAxis(RobotMap.XBC2shooterlow) > .15, CommandBase.oi.XBC2.getRawAxis(RobotMap.XBC2shooterhigh) > .15);
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
