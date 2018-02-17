package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.EncoderPIDSource;
import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;


public class DriveDistanceForward extends CommandBase {
	double distanceToDrive;
	private PIDController drivePID;
	private EncoderPIDSource pidSource;
	private PIDOutput dummy;
	private double speed = 0.75;
	
    public DriveDistanceForward(double inchDist, double setSpeed) {
       requires(CommandBase.drive);
       requires(CommandBase.sensors);
       
       distanceToDrive = inchDist;
       speed = setSpeed;
       
       pidSource = new EncoderPIDSource();
       drivePID = new PIDController(RobotMap.driveKp, 
    		   RobotMap.driveKi, RobotMap.driveKd, pidSource, dummy);
       drivePID.enable();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double[] encDistances = sensors.getEncoderDistance();
    	if(encDistances.length == 2) {
    		pidSource.encoderDistances = encDistances;
    		drivePID.setSetpoint(0);
    		double rotation = drivePID.get();
    		
    		double averageDistanceTraveled = (encDistances[0] + 
    				encDistances[1]) / 2;
    		
    		while(averageDistanceTraveled < (averageDistanceTraveled - 4)) {
    			drive.driveArcade(speed, rotation);
    		}
    		
    		drive.stop();
    	}
    	
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
