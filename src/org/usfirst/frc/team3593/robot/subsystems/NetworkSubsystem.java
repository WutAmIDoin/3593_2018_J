package org.usfirst.frc.team3593.robot.subsystems;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NetworkSubsystem extends Subsystem {
	public NetworkTable ntValues;
	public NetworkTable ntVision;
	public NetworkTable ntBehav;
	// The network table for 'power' is managed in the PowerSubsystem
    
	public NetworkSubsystem() {
		ntValues = NetworkTableInstance.getDefault().getTable("3593-Values");
		ntVision = NetworkTableInstance.getDefault().getTable("3593-Vision");
		ntBehav = NetworkTableInstance.getDefault().getTable("3593-Behavior");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

