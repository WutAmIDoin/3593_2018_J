package org.usfirst.frc.team3593.robot.commands;


public class ShooterCommand extends CommandBase {
	

    public ShooterCommand() {
    	requires(CommandBase.theShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean trigLeft = oi.XBC2.getRawAxis(2) > 0.15;
    	boolean trigRight = oi.XBC2.getRawAxis(3) > 0.15;
    	CommandBase.theShooter.SetShooterSpeed(trigLeft, trigRight);
    	
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
