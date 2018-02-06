package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;




public class DriveSubsystem extends Subsystem {

	Spark driveLeft;
	Spark driveRight;
	
	Solenoid shifter;
	
	AnalogGyro gyro;
	
	Encoder encoderLeft;
	Encoder encoderRight;
	
	NetworkTable ntVision;
	
	DifferentialDrive drive;
	
	
	public DriveSubsystem() {
		driveLeft = new Spark(RobotMap.driveLeftPWM);
		driveRight = new Spark(RobotMap.driveRightPWM);
		shifter = new Solenoid(RobotMap.shifter);
		gyro = new AnalogGyro(RobotMap.gyro);
		encoderLeft = new Encoder(RobotMap.encoderLeft1, RobotMap.encoderLeft2);
		encoderRight = new Encoder(RobotMap.encoderRight1, RobotMap.encoderRight2);
		ntVision = NetworkTableInstance.getDefault().getTable("Vision");
		//get default table then track "vision" table
		drive = new DifferentialDrive(driveLeft, driveRight);
	}
	
	public void driveTank(double left, double right) {
		drive.tankDrive(left, right);
	}
	
	
	Boolean shifterVar = false;
	long timeout = System.nanoTime();
	public void toggleShifter() {
		if(System.nanoTime()>timeout) {
			shifter.set(shifterVar);
			shifterVar =! shifterVar;
			timeout = System.nanoTime() + 2000000000;
		}
	}
    
			
    public void initDefaultCommand() {	
    }
}

