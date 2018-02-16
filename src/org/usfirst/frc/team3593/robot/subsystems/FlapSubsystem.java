package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

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
	   flap.set(flapVal);
   }
   
   public void flapUp() {
	   flap.set(true);
   }
   
   public void flapDown() {
	   flap.set(false);
   }
   // Add explicit setting methods for UP / DOWN

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

