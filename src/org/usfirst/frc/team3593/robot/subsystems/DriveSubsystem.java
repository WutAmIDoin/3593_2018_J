package org.usfirst.frc.team3593.robot.subsystems;
import org.usfirst.frc.team3593.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

	Spark driveLeft;
	Spark driveRight;
	DifferentialDrive DR;
	
	
	
	public DriveSubsystem() {
		driveLeft = new Spark(RobotMap.driveLeftPWM);
		driveRight = new Spark(RobotMap.driveRightPWM);
		DR = new DifferentialDrive (driveLeft, driveRight);
		
	}
	
	 public void driveTank(double left, double right) {
		 DR.tankDrive(left, right); 	 
	 }
	
	 public void stop() {
		 DR.tankDrive(0, 0);
	 }
	 
    public void initDefaultCommand() {
	}

	public void driveArcade(double speed, double rotation) {
		// TODO Auto-generated method stub
		
	}     
}   