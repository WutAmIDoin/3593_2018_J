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
    	
    	// Check to see if the side we're on (side) is the same as the first switch
    	//if so, shoot
    	if(fieldInfo.toUpperCase().charAt(0) == side.toUpperCase().charAt(0)) {
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(.5));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    	}
    }
}
