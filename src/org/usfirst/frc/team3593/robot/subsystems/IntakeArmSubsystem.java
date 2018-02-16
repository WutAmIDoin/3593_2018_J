package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeArmSubsystem extends Subsystem {
	Solenoid arms;
	
	public IntakeArmSubsystem() {
		arms = new Solenoid(RobotMap.intakearmSolenoidChannel);		
	}
    
	public void letsarm(boolean armworks) {
		arms.set(armworks);
	}

	public void setIn() {
		arms.set(true);
			}
	public void setOut() {
		arms.set(false);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

