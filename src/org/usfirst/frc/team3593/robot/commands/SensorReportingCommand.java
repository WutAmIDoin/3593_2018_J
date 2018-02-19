package org.usfirst.frc.team3593.robot.commands;



public class SensorReportingCommand extends CommandBase {

    public SensorReportingCommand() {
        requires(CommandBase.theSensor);
    }


    protected void initialize() {
    }


    protected void execute() {
    	CommandBase.ntValues.getEntry("gyroAngle")
		.setDouble(theSensor.getGyroAngle());
	
    	double[] encs = theSensor.getEncDistance();
    	CommandBase.ntValues.getEntry("driveLeftEncoder")
    	.setDouble(encs[0]);
    	CommandBase.ntValues.getEntry("driveRightEncoder")
    	.setDouble(encs[1]);
	
    	CommandBase.ntValues.getEntry("systemPressure")
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
