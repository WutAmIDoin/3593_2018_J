package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.PIDOutput;


public class TurnToDegree extends CommandBase {
	private PIDController pidGyro;
	private GyroPIDSource gyroPidSource;
	private PIDOutput dummy;
	private double setpoint;
	private double turnSpeed;
	private boolean finished;
	private double maxToleratedAngle;
	private double minToleratedAngle;
	
    public TurnToDegree(double newDegree, double speedPercent) {
        requires(CommandBase.drive);
        requires(CommandBase.sensors);
        
        setpoint = newDegree;
        turnSpeed = speedPercent;
        
        gyroPidSource = new GyroPIDSource();
        pidGyro = new PIDController(RobotMap.gyroKp, RobotMap.gyroKi, 
        		RobotMap.gyroKd, gyroPidSource, dummy);
        pidGyro.setPercentTolerance(RobotMap.gyroPIDTolerance);
        pidGyro.setOutputRange(-1, 1);
        
        maxToleratedAngle = setpoint + (setpoint * (RobotMap.gyroPIDTolerance / 100));
        minToleratedAngle = setpoint - (setpoint * (RobotMap.gyroPIDTolerance / 100));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	sensors.resetEncoderDistance();
    	sensors.resetGyro();
    	pidGyro.enable();
    	System.out.println("AUTO - GYRO - Turning to " + setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = sensors.getGyroAngle();
    	
    	Robot.ntValues.getEntry("gyroAngle").setDouble(angle);
    	
    	gyroPidSource.gyroAngle = angle;
    	pidGyro.setSetpoint(setpoint);
    	
    	double rotation = pidGyro.get();
    	
    	Robot.ntValues.getEntry("gyroPIDRotation")
    		.setDouble(rotation);
    	
    	drive.driveArcade(0, rotation * turnSpeed);
    	
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
