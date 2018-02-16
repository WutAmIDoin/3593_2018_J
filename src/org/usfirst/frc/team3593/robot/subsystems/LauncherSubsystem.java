package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LauncherSubsystem extends Subsystem {
Solenoid launcher;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public LauncherSubsystem() {
	launcher = new Solenoid(RobotMap.lifterSolenoidChannel);
}
public void letsLift(boolean itsLifted) {
	launcher.set(itsLifted);
}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

