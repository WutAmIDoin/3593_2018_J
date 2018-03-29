package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGScaleOnlyL extends CommandGroup {

    public CGScaleOnlyL(String FMSInfo) {
    	
    	//Preparations
    	//Shift and lower lifter and lift flap
    	addSequential(new SetShifter(false));
    	addSequential(new SetFlap(true));
    	addSequential(new BumpBackCommand());
    	
    	// Drive to the Corner of first switch and open intake arms
    	addSequential(new DriveForwardCommand(85, 0.85)); //or if 153 we go for the middle
    	addParallel(new SetFolders(true));
    	
    	if (FMSInfo.charAt(1) == 'L'){
    		
    		//Drive to scale
    		addSequential(new DriveForwardCommand(190, 0.85));
    		
    		//Turn To scale
    		addSequential(new TurnToDegree(55, 0.75));
    		
    		//Back up a bit
    		addSequential(new DriveForwardCommand(-8, 0.7));

    		//Score
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.scaleSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.5));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    	} else {
    		//Drive to center of side pathway (area between switch and scale) 
    		addSequential(new DriveForwardCommand(165, 0.85));
    		
    		//Turn right to drive across
    		addSequential(new TurnToDegree(90, 0.75));
    		
    		//Drive across pathway to opposite scale
    		addSequential(new DriveForwardCommand(166, 0.85));
    		
    		//Turn toward opposite scale
    		addSequential(new TurnToDegree(-85, 0.75));
    		
    		//Drive to scale 
    		addSequential(new DriveForwardCommand(54, 0.85));
    		
    		//Turn to scale
    		addSequential(new TurnToDegree(-50, 0.75));
    		
    		//Score
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.scaleSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.5));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    	}
    }
}
    
