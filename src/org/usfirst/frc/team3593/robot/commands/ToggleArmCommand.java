package org.usfirst.frc.team3593.robot.commands; 
 

 public class ToggleArmCommand extends CommandBase { 
 	Boolean finished = false; 
 	 
     public ToggleArmCommand() { 
         requires(CommandBase.intakeArms); 
     } 
 

     // Called just before this Command runs the first time 
     protected void initialize() { 
     } 
 
     // Called repeatedly when this Command is scheduled to run 
     protected void execute() { 
     	intakeArms.setPosition(CommandBase.toggleIntakeArmsControl); 
     	CommandBase.toggleIntakeArmsControl = !CommandBase.toggleIntakeArmsControl; 
     	finished = true; 
     } 
 
     // Make this return true when this Command no longer needs to run execute() 
     protected boolean isFinished() { 
         return finished; 
     } 
 
     // Called once after isFinished returns true 
     protected void end() { 
     } 
 

     // Called when another command which requires one or more of the same 
    // subsystems is scheduled to run 
    protected void interrupted() { 
     } 
 } 
