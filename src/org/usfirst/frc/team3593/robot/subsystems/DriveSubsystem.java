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
	Solenoid shifter;
	
	DifferentialDrive drive;
	
	AnalogGyro gyro;
	Encoder leftEncoder;
	Encoder rightEncoder;
	NetworkTable ntVision;
	
	public DriveSubsystem() {
		driveLeft = new Spark(RobotMap.driveLeftPWM);
		driveRight = new Spark(RobotMap.driveRightPWM);
		shifter = new Solenoid(RobotMap.shifterSolendoidChannel);
		
		drive = new DifferentialDrive(driveLeft, driveRight);
		
		gyro = new AnalogGyro(RobotMap.gyroChannel);
		leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
		rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);
		ntVision = NetworkTableInstance.getDefault().getTable("vision");
	}
	
	public void driveTank(double left, double right) {
		drive.tankDrive(left, right);
	}
	
	Boolean shifterVar = false;
	long timeout = System.nanoTime();
	public void toggleShifter() {
		if(System.nanoTime() > timeout)
		{
			shifter.set(shifterVar);
			shifterVar = !shifterVar;
			timeout = System.nanoTime() + 2000000000;
		}
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

