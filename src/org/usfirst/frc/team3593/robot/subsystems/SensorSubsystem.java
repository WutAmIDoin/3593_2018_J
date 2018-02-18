package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.SensorReportingCommand;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SensorSubsystem extends Subsystem {
	AnalogGyro gyro;
	Encoder leftEncoder;
	Encoder rightEncoder;
	AnalogInput pressureSensor;
	
	public SensorSubsystem() {
		gyro = new AnalogGyro(RobotMap.gyroChannel);
		
		leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
		rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);
		leftEncoder.setDistancePerPulse((RobotMap.wheelDiam * Math.PI) / RobotMap.encoderTicks);
		rightEncoder.setDistancePerPulse((RobotMap.wheelDiam * Math.PI) / RobotMap.encoderTicks);
		
		pressureSensor = new AnalogInput(RobotMap.pressureSensorChannel);
	}
	
	public double getGyroAngle() {
		return gyro.getAngle();
	}
	
	public void resetGyro() {
		gyro.reset();
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
	
	public double getPressure() {
		return 250 * (pressureSensor.getVoltage() / 5) - 25;
	}

    public void initDefaultCommand() {
        setDefaultCommand(new SensorReportingCommand());
    }
}

