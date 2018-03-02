package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForwardCommand extends CommandBase {

	private double distanceToDrive;
	private double speed = 0.75;
	private boolean finished = false;
	private boolean reversing = false;
	
    public DriveForwardCommand(double inchDist, double setSpeed) {
       requires(CommandBase.theDriveSubsystem);
       requires(CommandBase.theSensorSubsystem);
       
       if(inchDist < 0)
    	   reversing = true;
       
       distanceToDrive = inchDist;
       speed = setSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	theSensorSubsystem.resetEncoders();
    	theSensorSubsystem.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double[] encDistances = CommandBase.theSensorSubsystem.getEncDistance();
    	encDistances[0] = encDistances[0] *-1;
    	SmartDashboard.putNumber("Encoder Left", encDistances[0]);
    	SmartDashboard.putNumber("Encoder Right", encDistances[1]);
    	
    	if(encDistances.length == 2) {
    		//gyroPID.setSetpoint(0);
    		
    		double averageDistanceTraveled = (encDistances[0] + 
    				encDistances[1]) / 2;
    		
    		if(!reversing) {
    			CommandBase.theDriveSubsystem.driveArcade(speed, -0.31);
    			finished = averageDistanceTraveled > (distanceToDrive);
    			
    		}
    		else {
    			CommandBase.theDriveSubsystem.driveArcade(-speed, -0.31);
    			finished = averageDistanceTraveled < distanceToDrive;
    		}    				
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("DistanceDrive " + 
	    		distanceToDrive + " finished");
    	theDriveSubsystem.driveStop();
    	theSensorSubsystem.resetEncoders();
    	theSensorSubsystem.resetGyro();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("DistanceDrive " + 
	    		distanceToDrive + " finished");
    	theDriveSubsystem.driveStop();
    	theSensorSubsystem.resetEncoders();
    	theSensorSubsystem.resetGyro();
    }
}
