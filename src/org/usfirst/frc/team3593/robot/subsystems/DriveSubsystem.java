package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.*;

public class DriveSubsystem extends Subsystem {
	
	Spark driveR;
	Spark driveL;
	
	Solenoid shifter;
	
	AnalogGyro gyro;
	
	Encoder encL;
	Encoder encR;
	
	DifferentialDrive DR;
	
	NetworkTable ntVision;
	
	public DriveSubsystem() {
		driveL = new Spark(RobotMap.driveLeftPWM);
		driveR = new Spark(RobotMap.driveRightPWM);
		
		shifter = new Solenoid(RobotMap.shifters);
		
		gyro = new AnalogGyro(RobotMap.gryo);
		
		encL = new Encoder(RobotMap.encoderL1, RobotMap.encoderL2);
		encR = new Encoder(RobotMap.encoderR1, RobotMap.encoerR2);
		
		ntVision = NetworkTableInstance.getDefault().getTable("vision");
		
		DR = new DifferentialDrive(driveL, driveR);
	}
	
	public void driveTank(double left, double right) {
		DR.tankDrive(left, right);
	}
	
	Boolean shifterVar = false;
	long timeout = System.nanoTime();
	public void toggleShifter() {
		if(System.nanoTime()>timeout) {
			shifter.set(shifterVar);
			shifterVar = !shifterVar;
			timeout = System.nanoTime() + 2000000000;
			}
		}
			
			
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
}

