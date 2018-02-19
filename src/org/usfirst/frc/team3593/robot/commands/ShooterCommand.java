package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

public class ShooterCommand extends CommandBase {
	

    public ShooterCommand() {
    	requires(CommandBase.theShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(boolean trigLeft, boolean trigRight) {
    	trigLeft = oi.XBC2.getRawAxis(2) > 0.15;
    	trigRight = oi.XBC2.getRawAxis(3) > 0.15;
    	if(trigLeft) {
    		CommandBase.theShooter.SetShooterSpeed(RobotMap.lowTrig);
    	}else if(trigRight) {
    		CommandBase.theShooter.SetShooterSpeed(RobotMap.highTrig);
    		CommandBase.UpdateUpperLEDs("runningShooter");
    	}else {
    		CommandBase.theShooter.SetShooterSpeed(0);
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
