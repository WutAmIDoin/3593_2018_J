package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlapSubsystem extends Subsystem {

   Solenoid flap;
   
   public FlapSubsystem() {
	   flap = new Solenoid(RobotMap.flap);
   }
   
   public void SetFlap(boolean flapVal) {
	   if(flap.get() != flapVal) 
		   flap.set(flapVal);
	   	   CommandBase.toggleFlap = flapVal;
   }
   
   public void flapUp() {
	   if (!flap.get()) {
		   flap.set(true);
	   }
   }
   
   public void flapDown() {
	   if (flap.get()) {
		   flap.set(false);
	   }
   }
   // Add explicit setting methods for UP / DOWN

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

