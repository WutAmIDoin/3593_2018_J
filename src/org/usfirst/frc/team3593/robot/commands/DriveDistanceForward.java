package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.EncoderPIDSource;
import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;


public class DriveDistanceForward extends CommandBase {
	private double distanceToDrive;
	private PIDController drivePID;
	private EncoderPIDSource pidSource;
	private PIDOutput dummy;
	private double speed = 0.75;
	private boolean finished = false;
	
    public DriveDistanceForward(double inchDist, double setSpeed) {
       requires(CommandBase.drive);
       requires(CommandBase.sensors);
       
       distanceToDrive = inchDist;
       speed = setSpeed;
       
       // Create a new PID source and a aPID controller for 
       // calculating the rotation of the drive
       pidSource = new EncoderPIDSource();
       drivePID = new PIDController(RobotMap.driveKp, 
    		   RobotMap.driveKi, RobotMap.driveKd, pidSource, dummy);
       drivePID.setPercentTolerance(RobotMap.drivePIDTolerance);
       drivePID.setOutputRange(-1, 1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	sensors.resetEncoderDistance();
    	sensors.resetGyro();
    	drivePID.enable();
    	System.out.println("AUTO - ENCODERS - Driving " + distanceToDrive + "in");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Get the new angle of the gyro
    	double[] encDistances = sensors.getEncoderDistance();
    	
    	// Send this value to the network table
    	CommandBase.ntValues.getEntry("driveLeftEncoder").
    		setDouble(encDistances[0]);
    	CommandBase.ntValues.getEntry("driveRightEncoder").
			setDouble(encDistances[1]);
    	
    	// Check to make sure we got encoder values
    	if(encDistances.length == 2) {
    		// Set the PID source to the encoder distances 
    		// so that it can calculate the difference
    		pidSource.encoderDistances = encDistances;
    		
    		// Set the PID setpoint (aiming for no difference 
    		// between the two encoders) 
    		// Then get the calucalted PID value for rotation
    		drivePID.setSetpoint(0);
    		double rotation = drivePID.get();
    		
    		// Update NetworkTables
    		CommandBase.ntValues.getEntry("rotationCorrection")
    			.setDouble(rotation);
    		
    		// Calculate the average distance traveled by both sides
    		double averageDistanceTraveled = (encDistances[0] + 
    				encDistances[1]) / 2;
    		
    		// Drive with the speed and rotation we set / calculated
    		drive.driveArcade(speed, rotation);
    		
    		// If we've traveled the distance we want to, stop
    		finished = averageDistanceTraveled > (distanceToDrive - 6);
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
