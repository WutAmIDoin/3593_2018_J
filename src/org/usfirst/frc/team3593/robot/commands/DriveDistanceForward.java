package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.EncoderPIDSource;
import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class DriveDistanceForward extends CommandBase {

	private double distanceToDrive;
	private PIDController drivePID;
	private EncoderPIDSource pidSource;
	private PIDOutput dummy;
	private double speed = 0.75;
	private boolean finished = false;
	
    public DriveDistanceForward(double inchDist, double setSpeed) {
    	requires(CommandBase.theDrive);
    	requires(CommandBase.theSensor);
    	
    	distanceToDrive = inchDist;
    	speed = setSpeed;
    	
    	pidSource = new EncoderPIDSource();
    	drivePID = new PIDController(RobotMap.driveKp, RobotMap.driveKi, RobotMap.driveKd, pidSource, dummy);
    	drivePID.setPercentTolerance(RobotMap.drivePIDTolerance);
    	drivePID.setOutputRange(-1, 1);
    }


    protected void initialize() {
    	drivePID.enable();
    }


    protected void execute() {
    	double[] encDistances = theSensor.getEncDistance();
    	if(encDistances.length == 2) {
    		pidSource.encoderDistances = encDistances;
    		drivePID.setSetpoint(0);
    		double rotation = drivePID.get();
    		
    		double averageDistanceTraveled = (encDistances[0] + encDistances[1]/2);
    		
    		theDrive.driveArcade(speed, rotation);
    		
    		finished = averageDistanceTraveled > (distanceToDrive - 6);
    	}
    }


    protected boolean isFinished() {
        return finished;
    }


    protected void end() {
    	theDrive.driveStop();
    }


    protected void interrupted() {
    	theDrive.driveStop();
    }
}
