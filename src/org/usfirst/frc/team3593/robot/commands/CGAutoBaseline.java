package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAutoBaseline extends CommandGroup {

    public CGAutoBaseline(String fieldInfo, String side) {
    	//Drive to switch
    	addSequential(new DriveForwardCommand(120, .75));
    	//Stop motors just in case
    	addSequential(new DriveForwardCommand(0,0));
    	
    	// Check to see if the side we're on (side) is the same as the first switch
    	if(fieldInfo.toUpperCase().charAt(0) == side.toUpperCase().charAt(0)) {
    		// TODO SCORE
    	}
    	
    }
}
