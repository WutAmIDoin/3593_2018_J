package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.Robot;

public class SensorReportingCommand extends CommandBase {

    public SensorReportingCommand() {
        requires(CommandBase.theSensor);
    }


    protected void initialize() {
    }


    protected void execute() {
    	Robot.ntValues.getEntry("gyroAngle")
		.setDouble(theSensor.getGyroAngle());
	
    	double[] encs = theSensor.getEncDistance();
    	Robot.ntValues.getEntry("driveLeftEncoder")
    	.setDouble(encs[0]);
    	Robot.ntValues.getEntry("driveRightEncoder")
    	.setDouble(encs[1]);
	
    	Robot.ntValues.getEntry("systemPressure")
		.setDouble(theSensor.getPressure());
    }

    
    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }


    protected void interrupted() {
    }
}
