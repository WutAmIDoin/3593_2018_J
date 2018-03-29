package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAutoMiddle extends CommandGroup {

    public CGAutoMiddle(String FMSInfo) {
    	//Get everything in position
    	addSequential(new SetShifter(false));
    	addSequential(new SetLifter(true));
    	addSequential(new SetFlap(true));
    	addSequential(new BumpBackCommand());
    	
    	//Drive forward to about halfway down the field
    	addSequential(new DriveForwardCommand(25, 0.8));
    	addParallel(new SetFolders(true));
    	
    	//Determine switch side
    	if (FMSInfo.charAt(0) == 'L') {
    		//Turn to left for diagonal drive
    		addSequential(new TurnToDegree(-35, 0.75));
    		
    		//Drive Diagonally to switch
    		addSequential(new DriveForwardCommand(75.5, .8));
    		
    		//Turn to toward the scale
    		addSequential(new TurnToDegree(45, .75));
    		
    		//Drive to scale
    		addSequential(new DriveForwardCommand(5, 0.85));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    	}
    	else if (FMSInfo.charAt(0) == 'R'){
    		//Turn to right for diagonal drive
    		addSequential(new TurnToDegree(45, 0.75));
    		
    		//Drive Diagonally to switch
    		addSequential(new DriveForwardCommand(75.5, .8));
    		
    		//Turn to toward the scale
    		addSequential(new TurnToDegree(-45, .75));
    		
    		//Drive to scale
    		addSequential(new DriveForwardCommand(5, 0.85));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    	}
    }
}
