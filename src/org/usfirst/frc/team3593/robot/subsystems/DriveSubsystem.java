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
	
	Solenoid shifter;
	
	AnalogGyro gyro;
	
	Encoder encL;
	Encoder encR;
	
	
	NetworkTable ntVision;
	
	DifferentialDrive drive;
	
	
	
	
	public DriveSubsystem() {
	  
		_driveLeft = new Spark(RobotMap.driveLeftpwm);
		_driveRight = new Spark(RobotMap.driveRIghtpwm);
		
		shifter = new Solenoid(RobotMap.shifter);
		
		gyro = new AnalogGyro(RobotMap.gyro);
		
		encL = new Encoder(RobotMap.leftencoder1,RobotMap.Leftencoder2);
		encR = new Encoder(RobotMap.Rightencoder1,RobotMap.Rightencoder2);
		
	    ntVision = NetworkTableInstance.getDefault().getTable("vision");
	    
	    
				}
	public void driveTank(double left, double right) {
		drive.tankDrive(left, right);
	    
	    
	    }
	Boolean shifterVar = false;
	long timeout = System.nanoTime();
	public void toggleShifter() {
		if(System.nanoTime() > timeout);
		shifter.set(shifterVar);
		shifterVar =! shifterVar;
		timeout = System.nanoTime() + 2000000000;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

