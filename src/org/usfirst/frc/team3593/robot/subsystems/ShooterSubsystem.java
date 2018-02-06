package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Spark frontLeftSpark ;
	Spark frontRightSpark;
	Spark rearLeftSpark;
	Spark rearRightSpark;
	 
	Solenoid lifter;
	Solenoid booster;

	
	
	
	
	
	
	public ShooterSubsystem () {
		frontLeftSpark= new Spark (RobotMap.shooterFrontLeft);
		frontRightSpark= new Spark (RobotMap.shooterFrontRight);
		rearLeftSpark=new Spark (RobotMap.shooterRearLeft);
		rearRightSpark =new Spark (RobotMap.shooterRearRight);
		lifter = new Solenoid (RobotMap.lifterSolenoidChannel);
		booster= new Solenoid (RobotMap.boosterSolenoidChannel);
		
					
		
		
	}
	
	
	
	
	public void LiftCommand(Boolean Liftit) {
		lifter.set(Liftit);
	}
	
	public void Boost(Boolean Boostit) {
		booster.set(Boostit);
	}
	
	public void SetSpeed(Boolean lowTrig, Boolean highTrig) {
	
		if(lowTrig) {
			 double speed= highTrig ? RobotMap.highSpeedShooters : RobotMap.lowSpeedShooters;
			 frontLeftSpark.set(speed);
			 rearLeftSpark.set(speed);
			 frontRightSpark.set(-1*speed);
			 rearRightSpark.set(-1*speed);
			 } 
		else {
			frontLeftSpark.set(0);
			 rearLeftSpark.set(0);
			 frontRightSpark.set(0);
			 rearRightSpark.set(0);
			 
			 //set motors to 0
		}
		
	}
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

