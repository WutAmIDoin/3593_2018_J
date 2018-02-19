package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;


public class LaunchCube extends CommandBase {
	boolean finished = false;

    public LaunchCube() {
        requires(CommandBase.theShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	theBooster.setSolenoid(true);
    	Timer.delay(500);
    	theBooster.setSolenoid(false);
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	theBooster.setSolenoid(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	theBooster.setSolenoid(false);
    }
}