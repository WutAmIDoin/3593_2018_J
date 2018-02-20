package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class SetIntakeSpeed extends CommandBase {
	double speed;
	boolean finished = false;
	
    public SetIntakeSpeed(double set) {
        requires(CommandBase.intakeWheels);
        speed = set;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	intakeWheels.setSpeed(speed);
    	Timer.delay(1);
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
