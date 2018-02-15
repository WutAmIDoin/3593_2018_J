package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.*;

public class DriveSubsystem extends Subsystem {
	
	Spark driveR;
	Spark driveL;
	
	DifferentialDrive DR;
	
	public DriveSubsystem() {
		driveL = new Spark(RobotMap.driveLeftPWM);
		driveR = new Spark(RobotMap.driveRightPWM);
		
		DR = new DifferentialDrive(driveL, driveR);
	}
	
	public void driveTank(double left, double right) {
		DR.tankDrive(left, right);
	}
	
			
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
}

