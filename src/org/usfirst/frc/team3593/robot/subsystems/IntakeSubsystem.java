package org.usfirst.frc.team3593.robot.subsystems;
import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;
import org.usfirst.frc.team3593.robot.commands.RunIntakeMotors;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
	// Put methods for controlling this subsystem 
	     // here. Call these from Commands. 
	 	Spark[] leftSparks; 
	 	Spark[] rightSparks; 
	 	 
	 	public IntakeSubsystem() { 
	 		leftSparks = new Spark[] { 
	 			new Spark(RobotMap.intakerIntakeL), 
	 			new Spark(RobotMap.intakerSimL) 
	 		}; 
	 		rightSparks = new Spark[] { 
	 			new Spark(RobotMap.intakerIntakeR), 
	 			new Spark(RobotMap.intakerIntakeR2) 
	 		}; 
	 	} 
	 	 
	 	public void setSpeed(double setpoint) { 
	 		for(int x = 0; x < 2; x++) { 
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
	 		CommandBase.UpdateUpperLEDs("IN" + sendData); 
	 	} 
	 	 
	 	public void stopMotors() { 
	 		for(int x = 0; x < 2; x++) { 
	 			leftSparks[x].set(0); 
	 			rightSparks[x].set(0); 
	 		} 
	 		 
	 		CommandBase.UpdateUpperLEDs("INDEF"); 
	 	} 
	 
	 
	     public void initDefaultCommand() { 
	         setDefaultCommand(new RunIntakeMotors()); 
	     } 
	 } 

	