package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	Spark IntakeR;
	Spark IntakeL;
	Spark SimR;
	Spark SimL;
	
	public void IntakeSubystem() {
		IntakeR = new Spark(RobotMap.intakerIntakeR);
		IntakeL = new Spark(RobotMap.intakerIntakeL);
		SimR = new Spark(RobotMap.intakerSimR);
		SimL = new Spark(RobotMap.intakerSimL);
		
		
		
	}
	
	public void takein(double Takein) {
		IntakeR.set(-Takein);
		IntakeL.set(Takein);
		SimR.set(-Takein);
		SimL.set(Takein);
		
	}
	
	public void takeout(double takeout) {
		IntakeL.set(-takeout);
		IntakeR.set(takeout);
		SimR.set(takeout);
		SimL.set(-takeout);
	}
    


	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

