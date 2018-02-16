package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem 
	Spark frontLeftSpark ;
	Spark frontRightSpark;
	Spark rearLeftSpark;
	Spark rearRightSpark;
	 


	public ShooterSubsystem () {
		frontLeftSpark= new Spark (RobotMap.shooterFrontLeft);
		frontRightSpark= new Spark (RobotMap.shooterFrontRight);
		rearLeftSpark=new Spark (RobotMap.shooterRearLeft);
		rearRightSpark =new Spark (RobotMap.shooterRearRight);
		
	}
	
	public void SetSpeed(double speed) {
	
		frontLeftSpark.set(speed);
		rearLeftSpark.set(speed);
		frontRightSpark.set(speed);
		rearRightSpark.set(speed);
	}
	
	public void stop() {
		frontLeftSpark.set(0);
		rearRightSpark.set(0);
		frontRightSpark.set(0);
		frontLeftSpark.set(0);
	}
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

