package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;

import edu.wpi.first.wpilibj.DriverStation;

public class DriveDistanceForward extends CommandBase {
	private double distanceToDrive;
	private double speed = 0.75;
	private boolean finished = false;
	
    public DriveDistanceForward(double inchDist, double setSpeed) {
       requires(CommandBase.drive);
       requires(CommandBase.sensors);
       
       distanceToDrive = inchDist;
       speed = setSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	sensors.resetEncoderDistance();
    	sensors.resetGyro();
    	DriverStation.reportWarning("AUTO - ENCODERS - Driving " + 
    		distanceToDrive + "in", false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Get the new angle of the gyro
    	double[] encDistances = sensors.getEncoderDistance();
    	
    	// Send this value to the network table
    	Robot.ntValues.getEntry("driveLeftEncoder").
    		setDouble(encDistances[0]);
    	Robot.ntValues.getEntry("driveRightEncoder").
			setDouble(encDistances[1]);
    	
    	// Check to make sure we got encoder values
    	if(encDistances.length == 2) {
    		
    		// Calculate the average distance traveled by both sides
    		double averageDistanceTraveled = (encDistances[0] + 
    				encDistances[1]) / 2;
    		
    		// Drive with the speed and rotation, plus observed rotation offset 0.3
    		drive.driveArcade(speed, 0.3 + (-sensors.getGyroAngle() * RobotMap.driveKp));
    		
    		// If we've traveled the distance we want to, stop
    		finished = averageDistanceTraveled > (distanceToDrive - 4);
    	}
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
