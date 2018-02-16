package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SensorSubsystem extends Subsystem {
	
	AnalogGyro gyro;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public SensorSubsystem() {
		
		gyro = new AnalogGyro(RobotMap.gyro);
	}
	
	public double GyroIsPyro() {
		
		return gyro.getAngle();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

