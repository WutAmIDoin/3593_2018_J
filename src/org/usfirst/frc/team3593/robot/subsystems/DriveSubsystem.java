package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 *
 */
public class DriveSubsystem extends Subsystem {
	
	Spark _driveLeft;
	Spark _driveRight;
	
	DifferentialDrive DR;
	
	
	public DriveSubsystem() {
	  
		_driveLeft = new Spark(RobotMap.driveLeftpwm);
		_driveRight = new Spark(RobotMap.driveRIghtpwm);
		
		DR = new DifferentialDrive(_driveLeft, _driveRight);
				}
	public void driveTank(double left, double right) {
		DR.tankDrive(left, right);
	    
	    
	    }


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

