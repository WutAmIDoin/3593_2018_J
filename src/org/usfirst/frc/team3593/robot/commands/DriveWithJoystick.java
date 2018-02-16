package org.usfirst.frc.team3593.robot.commands;

public class DriveWithJoystick extends CommandBase {

    public DriveWithJoystick() {
        requires(CommandBase.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.driveTank(CommandBase.oi._XBC1.getRawAxis(1), 
    			-CommandBase.oi._XBC1.getRawAxis(5));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
