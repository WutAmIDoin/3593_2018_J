package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SensorSubsystem extends Subsystem {

    Encoder encL;
    Encoder encR;
    
    AnalogGyro gyro;
    
    AnalogInput PS;
    
    public SensorSubsystem() {
    	encL = new Encoder(RobotMap.encL1, RobotMap.encL2);
		encR = new Encoder(RobotMap.encR1, RobotMap.encR2);
		encL.setDistancePerPulse(RobotMap.encoderDPP);
		encR.setDistancePerPulse(RobotMap.encoderDPP);	

		gyro = new AnalogGyro(RobotMap.gyro);

		PS = new AnalogInput(RobotMap.pressureSensor);
    }

    public double getGyroAngle() {
		return gyro.getAngle();
	}
	
	public double[] getEncDistance() {
		return new double[] {
				encL.getDistance(),
				encR.getDistance()
		};
	}
	
	public void resetGyro() {
		gyro.reset();
	}
	
	public void resetEncoders() {
		encL.reset();
		encR.reset();
	}
	
	public double getPressure() {
		return 250 * (PS.getVoltage() / 5) - 25; 
	}
    
    public void initDefaultCommand() {

    }
}

