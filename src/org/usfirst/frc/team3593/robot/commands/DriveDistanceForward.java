package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.EncoderPIDSource;
import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveDistanceForward extends CommandBase {

	private double distanceToDrive;
	private PIDController drivePID;
	private EncoderPIDSource pidSource;
	private PIDOutput dummy;
	private double speed = 0.75;
	private boolean finished = false;
	private boolean reversing = false;
	
    public DriveDistanceForward(double inchDist, double setSpeed) {
    	requires(CommandBase.theDrive);
    	requires(CommandBase.theSensor);
    	
        if(inchDist < 0)
     	   reversing = true;
    	
    	distanceToDrive = inchDist;
    	speed = setSpeed;
    	
    	dummy = new DummyPIDOutput();
    	pidSource = new EncoderPIDSource();
    	drivePID = new PIDController(RobotMap.driveKp, RobotMap.driveKi, RobotMap.driveKd, pidSource, dummy);
    	drivePID.setPercentTolerance(RobotMap.drivePIDTolerance);
    	drivePID.setOutputRange(-1, 1);
    }


    protected void initialize() {
    	drivePID.enable();
    	System.out.println("DriveDistance starting - " + distanceToDrive + "in - speed = " + speed);
    	theSensor.resetEncoders();
    	theSensor.resetGyro();
    }


    protected void execute() {
    	double[] encDistances = theSensor.getEncDistance();
    	encDistances[0] = encDistances[0] *-1;
    	SmartDashboard.putNumber("Encoder Left", encDistances[0]);
    	SmartDashboard.putNumber("Encoder Right", encDistances[1]);
    	
    	if(encDistances.length == 2) {
    		pidSource.encoderDistances = encDistances;
    		drivePID.setSetpoint(0);
    		
    		double averageDistanceTraveled = (encDistances[0] + encDistances[1]/2);
    		if(!reversing) {
    			CommandBase.theDrive.driveArcade(speed, -0.31);
    			finished = averageDistanceTraveled > (distanceToDrive);
    		}
    		else {
    			CommandBase.theDrive.driveArcade(-speed, -0.31);
    			finished = averageDistanceTraveled < distanceToDrive;
    		} 
    	}
    }


    protected boolean isFinished() {
        return finished;
    }


    protected void end() {
    	System.out.println("DistanceDrive " + 
	    		distanceToDrive + " finished");
    	theDrive.driveStop();
    	theSensor.resetEncoders();
    	theSensor.resetGyro();
    }


    protected void interrupted() {
    	System.out.println("DistanceDrive " + 
	    		distanceToDrive + " finished");
    	theDrive.driveStop();
    	theSensor.resetEncoders();
    	theSensor.resetGyro();
    }
}
