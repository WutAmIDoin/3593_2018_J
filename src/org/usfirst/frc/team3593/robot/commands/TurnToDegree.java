package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;
import edu.wpi.first.wpilibj.*;


public class TurnToDegree extends CommandBase {
	private double setpoint;
	private double turnSpeed;
	private boolean finished;
	private double maxToleratedAngle;
	private double minToleratedAngle;
	
    public TurnToDegree(double newDegree, double turnspeed) {
        requires(CommandBase.drive);
        requires(CommandBase.sensors);
        
        setpoint = newDegree;
        turnSpeed = turnspeed > 0.75 ? 0.75 : turnspeed;
        
        maxToleratedAngle = setpoint + (setpoint * (RobotMap.gyroTolerance / 100));
        minToleratedAngle = setpoint - (setpoint * (RobotMap.gyroTolerance / 100));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	sensors.resetEncoderDistance();
    	sensors.resetGyro();
    	DriverStation.reportWarning("AUTO - GYRO - Turning to " + setpoint, false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = sensors.getGyroAngle();
    	
    	Robot.ntValues.getEntry("gyroAngle").setDouble(angle);
    	
    	drive.driveArcade(0, (angle * RobotMap.gyroKp) + turnSpeed);
    	
    	finished = angle < maxToleratedAngle && angle > minToleratedAngle;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drive.stop();
    }
}
