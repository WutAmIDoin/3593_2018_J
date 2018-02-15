package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BoosterSubsystem extends Subsystem {
	
	Solenoid launcher;
	
	public BoosterSubsystem() {
		launcher = new Solenoid(RobotMap.booster);
	}

	public void SetLauncher(boolean setLauncher) {
		launcher.set(setLauncher);
	}
	
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
}

