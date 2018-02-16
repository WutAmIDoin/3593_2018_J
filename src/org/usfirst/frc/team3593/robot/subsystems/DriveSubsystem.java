package org.usfirst.frc.team3593.robot.subsystems;
import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

	Spark driveLeft;
	Spark driveRight;
	DifferentialDrive DR;
	
	
	
	public DriveSubsystem() {
		driveLeft = new Spark(RobotMap.driveLeftPWM);
		driveRight = new Spark(RobotMap.driveRightPWM);
		DR = new DifferentialDrive (driveLeft, driveRight);
		
	}
	
	 public void driveTank(double left, double right) {
	   DR.tankDrive(left, right); 	 
	 }
	 
	 
		  
	  
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        

   
    }
}



