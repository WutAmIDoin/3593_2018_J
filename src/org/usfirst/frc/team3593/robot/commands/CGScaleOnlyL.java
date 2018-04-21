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
    		addSequential(new DriveForwardCommand(185, 0.85));
    		
    		//Turn To scale
    		addSequential(new TurnToDegree(70, 0.75));
    		
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
    		
    		//Turn toward second cube
    		addSequential(new TurnToDegree(-92, 0.75));
    		
    		addSequential(new SetLifter(true));
    		addSequential(new SetIntake(0.9));
    		
    		//Back up about 3/4 the way at max speed
    		addSequential(new DriveForwardCommand(-75, 0.75));
    		
    		addSequential(new SetFlap(false));
    		addSequential(new DelayCommand(0.5));
    		//Set Flap down and pick up cube and activate intake
    		//addSequential(new DriveForwardCommand(28, 0.65));
    		
    		
    		//Pause the Intake and Run again to ensure good cube pick up
    		
    		
    		addSequential(new SetLifter(false));
    		//Drive back to scale
    		addSequential(new DriveForwardCommand(75, 0.95));
    		
    		addSequential(new SetIntake(0));
    		addSequential(new DelayCommand(0.5));
    		addSequential(new SetIntake(0.9));
    		//Turn to scale
    		addSequential(new TurnToDegree(90, 0.75));
    		addParallel(new SetIntake(0));
    		
    		//Shoot
    		addSequential(new SetShooter(RobotMap.scaleSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.3));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    	} else {    		
    		//Drive to center of side pathway (area between switch and scale) 
    		addSequential(new DriveForwardCommand(122, 0.85));
    		
    		//Turn right to drive across
    		addSequential(new TurnToDegree(95, 0.75));
    		
    		//Drive across pathway to opposite scale
    		addSequential(new DriveForwardCommand(232, 0.85));
    		
    		//Turn toward opposite scale
    		addSequential(new TurnToDegree(-90, 0.75));
    		
    		//Drive to scale 
    		addSequential(new DriveForwardCommand(34, 0.85));
    		
    		//Turn to scale
    		addSequential(new TurnToDegree(-30, 0.75));
    		
    		//Score
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.scaleSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.5));
   	
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//Turn toward second cube
    		addSequential(new TurnToDegree(95, 0.75));
    		
    		addSequential(new SetLifter(true));
    		
    		//Back up about 3/4 the way at max speed
    		addSequential(new DriveForwardCommand(-75, 0.85));
    		
    		addSequential(new SetFlap(false));
    		addParallel(new SetIntake(0.9));
    		//Set Flap down and pick up cube and activate intake
    		addSequential(new DriveForwardCommand(28, 0.65));
    		
    		
    		//Pause the Intake and Run again to ensure good cube pick up
    		addSequential(new SetIntake(0));
    		addSequential(new DelayCommand(0.3));
    		addSequential(new SetIntake(0.9));
    		
    		addSequential(new SetLifter(false));
    		//Drive back to scale
    		addSequential(new DriveForwardCommand(90, 0.85));
    		
    		//Turn to scale
    		addSequential(new TurnToDegree(-95, 0.75));
    		addParallel(new SetIntake(0));
    		
    		//Shoot
    		addSequential(new SetShooter(RobotMap.scaleSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.3));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    	}
    }
}
    
