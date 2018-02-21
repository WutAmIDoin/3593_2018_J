package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.GyroPIDSource;
import org.usfirst.frc.team3593.robot.Robot;
import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnToDegree extends CommandBase {
	//private PIDController pidGyro;
	//private GyroPIDSource gyroPidSource;
	//private DummyPIDOutput dummy;
	private double setpoint;
	private double turnSpeed;
	private boolean finished;
	private double maxToleratedAngle;
	private double minToleratedAngle;
	
    public TurnToDegree(double newDegree, double speedPercent) {
        requires(CommandBase.theDriveSubsystem);
        requires(CommandBase.theSensorSubsystem);
        
        setpoint = newDegree > 0 ? newDegree - 8 : newDegree + 8;
        turnSpeed = speedPercent;
        
        //dummy = new DummyPIDOutput();
        //gyroPidSource = new GyroPIDSource();
        //pidGyro = new PIDController(RobotMap.gyroKp, RobotMap.gyroKi, 
        //		RobotMap.gyroKd, gyroPidSource, dummy);
        //pidGyro.setPercentTolerance(RobotMap.gyroPIDTolerance);
        //pidGyro.setOutputRange(-1, 1);
        
        //pidGyro.setOutputRange(-1, 1);
        //pidGyro.setPercentTolerance(2);
        
        maxToleratedAngle = setpoint + (setpoint * (RobotMap.gyroPIDTolerance / 100));
        minToleratedAngle = setpoint - (setpoint * (RobotMap.gyroPIDTolerance / 100));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//pidGyro.enable();
    	System.out.println("TurnToDegree starting - " + setpoint + " degrees - speed = " + turnSpeed);
    	theSensorSubsystem.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = theSensorSubsystem.getGyroAngle();
    	SmartDashboard.putNumber("Gyro Angle", angle);
//    	
//    	Robot.ntValues.getEntry("gyroAngle").setDouble(angle);
//    	
//    	gyroPidSource.gyroAngle = angle;
//    	pidGyro.setSetpoint(setpoint);
//    	double rotation = pidGyro.get();
//    	SmartDashboard.putNumber("GYROPIDVALUE", rotation);
//    	Robot.ntValues.getEntry("gyroPIDRotation").setDouble(rotation);    	
//    	theDriveSubsystem.driveArcade(0, rotation * turnSpeed);
//    	
//    	finished = angle < maxToleratedAngle && angle > minToleratedAngle;
    	
    	if(angle > setpoint - 4 && angle < setpoint + 4 )
    	{
    		theDriveSubsystem.driveStop();
    		finished = true;
    		System.out.println("TurnToDegree " + 
    	    		setpoint + " finished");
    	}
    	else
    	{
    		if(angle < setpoint)
    			theDriveSubsystem.driveTank(turnSpeed, -turnSpeed);
    		else
    			theDriveSubsystem.driveTank(-turnSpeed, turnSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	theDriveSubsystem.driveStop();
    	theSensorSubsystem.resetEncoders();
    	theSensorSubsystem.resetGyro();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	theDriveSubsystem.driveStop();
    	theSensorSubsystem.resetEncoders();
    	theSensorSubsystem.resetGyro();
    }
}
