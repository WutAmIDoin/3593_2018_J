package org.usfirst.frc.team3593.robot.commands; 
 
 
 import edu.wpi.first.wpilibj.Spark; 
 
public class ChargeShooters extends CommandBase { 
 	Spark[] leftSparks; 
 	Spark[] rightSparks; 
 
     public ChargeShooters() { 
         requires(CommandBase.shooterWheels); 
     } 
 
    // Called just before this Command runs the first time 
     protected void initialize() { 
     } 
 

     // Called repeatedly when this Command is scheduled to run 
     protected void execute() { 
     	double speed = 0; 
     	shooterWheels.setSpeed(speed); 
     } 
 

     // Make this return true when this Command no longer needs to run execute() 
     protected boolean isFinished() { 
         return false; 
     } 
 

     // Called once after isFinished returns true 
     protected void end() { 
     	shooterWheels.setSpeed(0); 
     } 

     // Called when another command which requires one or more of the same 
     // subsystems is scheduled to run 
     protected void interrupted() { 
     	shooterWheels.setSpeed(0); 
     } 
 } 
