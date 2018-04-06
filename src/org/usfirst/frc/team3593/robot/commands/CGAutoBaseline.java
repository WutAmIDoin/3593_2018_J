package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAutoBaseline extends CommandGroup {

    public CGAutoBaseline(String fieldInfo, String side) {
    	//Drive to switch, touching the edge with bumpers

    	
    	
    	
    	//original
    	addSequential(new DriveForwardCommand(140, .65));
    	//Stop motors just in case
    	addSequential(new DriveForwardCommand(0,0));
    	}
    }
