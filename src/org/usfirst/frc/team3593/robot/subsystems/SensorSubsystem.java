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

	AnalogInput pressureSensor;

	

	public SensorSubsystem() {

		gyro = new AnalogGyro(RobotMap.gyro);

		

		leftEncoder = new Encoder(RobotMap.encoderL1, RobotMap.encoderL2);

		rightEncoder = new Encoder(RobotMap.encoderR1, RobotMap.encoderR2);

		leftEncoder.setDistancePerPulse((RobotMap.wheelDiameter * Math.PI) / RobotMap.encoderDPP);

		rightEncoder.setDistancePerPulse((RobotMap.wheelDiameter * Math.PI) / RobotMap.encoderDPP);

		

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

        // Set the default command for a subsystem here.

        //setDefaultCommand(new MySpecialCommand());

    }

}

