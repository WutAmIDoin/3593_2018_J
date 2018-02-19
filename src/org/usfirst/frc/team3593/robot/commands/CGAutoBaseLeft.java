package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class CGAutoBaseLeft extends CommandGroup {
    public CGAutoBaseLeft() {
    	// Drive forward a little bit, not touching the cube pile
    	addSequential(new DriveDistanceForward(40, 0.75));
    	addSequential(new SetFolder(true));
    	// Turn and drive to the left switch
    	addSequential(new TurnToDegree(30, 0.5));
    	addSequential(new DriveDistanceForward(80, 0.75));
    	// Turn back so now facing the switch
    	addSequential(new TurnToDegree(-30, 0.5));
    	// Score in the switch
    	addSequential(new SetShooter(RobotMap.switchSpeed));
		addSequential(new LaunchCube());
    }
}
