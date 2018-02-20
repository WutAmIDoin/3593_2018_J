package org.usfirst.frc.team3593.robot.subsystems;
import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

	Spark driveLeft;
	Spark driveRight;
	
	DifferentialDrive drive;
	
	public DriveSubsystem() {
		driveLeft = new Spark(RobotMap.driveLeftPWM);
		driveRight = new Spark(RobotMap.driveRightPWM);
		
		drive = new DifferentialDrive(driveLeft, driveRight);
	}
	
	public void driveTank(double left, double right) {
		if(RobotMap.driveReversed) // if drive is reversed
			drive.tankDrive(right * -1, left * -1); // reverse joystick sides as well
		else
			drive.tankDrive(left, right); // drive normally
	}
	
	public void driveArcade(double speed, double rotation) {
		int revCoeff = RobotMap.driveReversed ? -1 : 1;
		drive.arcadeDrive(speed * revCoeff, rotation * revCoeff, false);
	}
	
	public void stop() {
		drive.stopMotor();
	}
		
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand( new DriveWithJoystick() );
    }
}

