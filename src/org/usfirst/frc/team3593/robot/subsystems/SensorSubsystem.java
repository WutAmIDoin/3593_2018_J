package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SensorSubsystem extends Subsystem {
	AnalogGyro gyro;
	Encoder leftEncoder;
	Encoder rightEncoder;
	
	public SensorSubsystem() {
		gyro = new AnalogGyro(RobotMap.gyroChannel);
		leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
		rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);
	}
	
	public double getGyroAngle() {
		return gyro.getAngle();
	}
	
	public void calibrateGyro() {
		gyro.calibrate();
	}
	
	public double[] getEncoderDistance() {
		return new double[] {
			leftEncoder.getDistance(),
			rightEncoder.getDistance(),
		};
	}
	
	public void resetEncoderDistance() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

