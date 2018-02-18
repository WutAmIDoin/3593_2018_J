package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	
	Spark IntakeL;
	Spark IntakeR;
	Spark SimL;
	Spark SimR;
	
	public IntakeSubsystem() {
		
		IntakeL = new Spark(RobotMap.IntakeL);
		IntakeR = new Spark(RobotMap.IntakeR);
		SimL = new Spark(RobotMap.SimL);
		SimR = new Spark(RobotMap.SimR);

	}

	public void intakeSetSpeed(double setpoint) {
		setpoint = setpoint * 0.75;
		
		IntakeL.set(-setpoint);
		IntakeR.set(setpoint);
		SimL.set(-setpoint);
		SimR.set(setpoint);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void setPosition(boolean setpoint) {
		// TODO Auto-generated method stub
		
	}

	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		
	}
}

