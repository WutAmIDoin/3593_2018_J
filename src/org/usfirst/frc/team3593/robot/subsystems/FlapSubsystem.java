package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlapSubsystem extends Subsystem {

   Solenoid flap;

  
	public FlapSubsystem(){
		flap = new Solenoid(RobotMap.flapSolenoidChannel);
		
	}
	public void setTheFlap(boolean setFlap) {
		flap.set(setFlap);
		
	}

    public void initDefaultCommand() {

    }
}

