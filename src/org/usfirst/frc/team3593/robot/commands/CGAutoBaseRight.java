package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class CGAutoBaseRight extends CommandGroup {

    public CGAutoBaseRight() {
        addSequential(new DriveDistanceForward(20, 0.75));
        addSequential(new TurnToDegree(-15, 0.5));
        addSequential(new DriveDistanceForward(90, 0.75));
        addSequential(new TurnToDegree(15, 0.5));
        addSequential(new SetShooter(RobotMap.switchSpeed));
		addSequential(new LaunchCube());
    }
}
