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
    	
    	double speed = 0;
		if (CommandBase.oi.XBC2.getRawAxis(RobotMap.XBC2shooterlow) > .15) {
			speed = (CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC2shooterhigh) > .15) ? RobotMap.shooterHighSpeed: RobotMap.shooterLowSpeed;
			CommandBase.theShooterSubsystem.SetShooterSpeed(speed);
			CommandBase.UpdateUpperLEDs("runningShooter");
		} 
		else {
			CommandBase.theShooterSubsystem.stopShooters();
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
