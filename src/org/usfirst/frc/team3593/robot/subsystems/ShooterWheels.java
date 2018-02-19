package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterWheels extends Subsystem {
//Put methods for controlling this subsystem
	//her.Call these from Commands
	Spark[] leftSparks;
	Spark[] rightSparks;
	
	public ShooterWheels() {
		leftSparks = new Spark[] {
				new Spark(RobotMap.shooterFrontLeft),
				new Spark(RobotMap.shooterRearLeft)
		};
		rightSparks = new Spark[] {
				new Spark(RobotMap.shooterFrontRight),
				new Spark(RobotMap.shooterRearRight)
		};
	}
	
	public void setSpeed(double setpoint) {
		for(int x = 0; x<2; x++) {
			leftSparks[x].set(setpoint);
			rightSparks[x].set(-setpoint);
		}
	
		String sendData = ""; 
		 		if(setpoint > 0.95) { 
		 			sendData = "FULL"; 
		 		} else if(setpoint > 0.5) { 
		 			sendData = "HALF"; 
		 		} else { 
		 			sendData = "DEF"; 
		 		} 
		 		CommandBase.UpdateUpperLEDs("SHOT" + sendData);
		 		
	}
	
	public void stopMotors() { 
		 		for(int x = 0; x < 2; x++) { 
		 			leftSparks[x].set(0); 
		 			rightSparks[x].set(0); 
		 		} 
		 		 
		 		CommandBase.UpdateUpperLEDs("SHOTDEF"); 
	} 

public void initDefaultCommand() {
  //Need to create a default SetShooterSpeed
	//command for this
    }
}

