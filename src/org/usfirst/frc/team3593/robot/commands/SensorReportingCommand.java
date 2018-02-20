package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;

/**
 *
 */
public class SensorReportingCommand extends CommandBase {

    public SensorReportingCommand() {
    	requires(CommandBase.sensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ntValues.getEntry("gyroAngle")
    		.setDouble(sensors.getGyroAngle());
    	
    	double[] encs = sensors.getEncoderDistance();
    	Robot.ntValues.getEntry("driveLeftEncoder")
		.setDouble(encs[0]);
    	Robot.ntValues.getEntry("driveRightEncoder")
		.setDouble(encs[1]);
    	
    	Robot.ntValues.getEntry("systemPressure")
			.setDouble(sensors.getPressure());
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
