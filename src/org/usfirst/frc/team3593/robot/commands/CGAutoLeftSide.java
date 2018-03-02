package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAutoLeftSide extends CommandGroup {

	public CGAutoLeftSide(String FMSInfo) {    	
    	// PLAN--------------------------
    	boolean reverseScaleSide = false;
    	boolean shoot = false;
    	
    	//Preparations
    	//Shift and lower lifter and lift flap
    	addSequential(new SetShifter(false));
    	addSequential(new SetLifter(true));
    	addSequential(new SetFlap(true));
    	
    	// Drive to the Corner of first switch and open intake arms
    	addSequential(new DriveForwardCommand(110, 0.75)); //or if 153 we go for the middle
    	addParallel(new SetFolders(true));
    	
    	// If the left switch is our color
    	if(FMSInfo.charAt(0) == 'L') {
    		// Turn to face the switch
    		addSequential(new TurnToDegree(-45, 0.70));
    		
    		//Drive toward switch
    		addSequential(new DriveForwardCommand(10, 0.75));
    		
    		//Score
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.5));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//Drive back and away
    		addSequential(new DriveForwardCommand(-10, 0.75));
    		
    		// Turn back to facing forward
    		addSequential(new TurnToDegree(45, 0.70));
    	
    	} else {
    		// Drive to the end of the first switch
        	addSequential(new DriveForwardCommand(110, 0.75));//or 81 if going for mid
        	
        	// Turn the robot 90 degrees
        	addSequential(new TurnToDegree(-90, 0.70));
        	
        	// Drive to the other side of the switch
        	addSequential(new DriveForwardCommand(155, 0.75));
        	
        	// Turn to face the switch
        	addSequential(new TurnToDegree(-90, 0.70));
        	
        	//Drive Forward to Switch
        	addSequential(new DriveForwardCommand(15, 0.65));
        	
        	// Score in the switch
        	//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.5));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//Back away from the switch
    		addSequential(new DriveForwardCommand(-15, 0.75));
    		
        	reverseScaleSide = true;
    	}
    	
    	// If the scale side we're now closest to is also our color
    	if(FMSInfo.charAt(1) == 'L' || reverseScaleSide) {
    		// TODO Attempt to score in scale
    		if(reverseScaleSide && FMSInfo.charAt(1) == 'R') //for if we are on the reverse side and have the scale on right
    		{
	    		// Turn around to get a cube while setting intake
	    		addSequential(new TurnToDegree(180, 0.50));
	    		addParallel(new SetIntake(0.75));
	    		
	    		//TODO do we need to re angle??? figure out where robot ends up relative to cubes 
	    		
	    		// Backup to get the cube
	    		addSequential(new DriveForwardCommand(-10, -0.65));
	    		
	    		//Back Away from switch
	    		addSequential(new DriveForwardCommand(10, 0.65));
	    		
	    		//Turn towards scale
	    		addSequential(new TurnToDegree(45, 0.75));
	    		
	    		//Turn off Intake
	    		addSequential(new SetIntake(0));
	    		
	    		//Drive to Scale
	    		addSequential(new DriveForwardCommand(40, 0.75));
	    		
	    		//Set Lifters UP
	    		addSequential(new SetLifter(false));
	    		
	    		//Turn to shoot
	    		addSequential(new TurnToDegree(-45, 0.7));
	    		
	    		shoot = true;
    		
    		} else if (FMSInfo.charAt(1) == 'L') { //this for if we are not at the reverse side and we get the left side scale
    			// Drive to the end of the first switch
            	addSequential(new DriveForwardCommand(112, 0.75));//or 83
            	
            	// Turn the rear wheels towards the nearest cube
            	addSequential(new TurnToDegree(45, 0.70));
            	
            	// Backup to get the cube and activate intake
	    		addSequential(new DriveForwardCommand(-15, -0.65));
	    		addParallel(new SetIntake(0.75));
	    		
	    		//Turn Slightly to add alignment to the scale
	    		addSequential(new TurnToDegree(-10, 0.75));
	    		
	    		// Move away from the switch and toward scale 
	    		addSequential(new DriveForwardCommand(45, 0.7));//this distance is not set
	    		
	    		//Stop the Intake
	    		addSequential(new SetIntake(0));
	    		
	    		//Set the Lifter to UP
	    		addSequential(new SetLifter(false));
	    		
	    		// Turn toward the scale and shoot
            	addSequential(new TurnToDegree(90, 0.70));//or 135
            	
            	shoot = true;
    		}
    		//For if we want to shoot
    		if (shoot) {
    		//Delay for Lifter
    		addSequential(new DelayCommand(0.5));
    		
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
    	
    	// Fin
    }
}
