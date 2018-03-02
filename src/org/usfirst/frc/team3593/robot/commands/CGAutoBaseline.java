package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAutoBaseline extends CommandGroup {

    public CGAutoBaseline() {
    	//Drive Past Baseline
    	addSequential(new DriveForwardCommand(130, .75));
    	//Stop motors just in case
    	addSequential(new DriveForwardCommand(0,0));
    }
}
