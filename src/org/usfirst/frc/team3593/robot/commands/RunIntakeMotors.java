package org.usfirst.frc.team3593.robot.commands;
import org.usfirst.frc.team3593.robot.RobotMap;

public class RunIntakeMotors extends CommandBase {
	  public RunIntakeMotors() { 
		          requires(CommandBase.intakeWheels); 
		           requires(CommandBase.flap); 
		       } 
		   
		  
		       // Called just before this Command runs the first time 
		       protected void initialize() { 
		       	flap.setDown(); 
		       } 
		   
		   
		       // Called repeatedly when this Command is scheduled to run 
		       protected void execute() { 
		       	double speed = 0; 
		       	 
		       	// Get absolute value of the trigger axis, just in case  
		       	if(Math.abs(oi._XBC1.getRawAxis(2)) > RobotMap.trigDeadzone) { 
		       		speed = 0.75; 
		       		flap.setDown(); 
		       	} else if(Math.abs(oi._XBC1.getRawAxis(3)) > RobotMap.trigDeadzone) { 
		       		speed = -0.75; 
		       		flap.setDown(); 
		       	} else { 
		       		speed = 0; 
		       	///I'm not sure.
		       		flap.setUp(); 
		       	} 
		       	 
		       	intakeWheels.setSpeed(speed); 
		       } 
		   
		   
		       // Make this return true when this Command no longer needs to run execute() 
		       protected boolean isFinished() { 
		           return false; 
		       } 
		   
		  
		       // Called once after isFinished returns true 
		       protected void end() { 
		       	flap.setDown(); 
		       } 
		   
		  
		       // Called when another command which requires one or more of the same 
		       // subsystems is scheduled to run 
		       protected void interrupted() { 
		       	flap.setDown(); 
		       } 
		   } 
