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
    	boolean atSwitch = false;
    	boolean shoot = false;
    	
    	//Preparations
    	//Shift and lower lifter and lift flap
    	addSequential(new SetShifter(false));
    	addSequential(new SetFlap(true));
    	addSequential(new BumpBackCommand());
    	
    	// Drive to the Corner of first switch and open intake arms
    	addSequential(new DriveForwardCommand(85, 0.75)); //or if 153 we go for the middle
    	addParallel(new SetFolders(true));
    	
    	// If the left switch is our color
    	if(FMSInfo.charAt(0) == 'L') {
    		// Turn to face the switch
    		addSequential(new TurnToDegree(45, 0.70));
    		
    		//Lower Lifter
    		addSequential(new SetLifter(true));
    		
    		//Drive toward switch
    		addSequential(new DriveForwardCommand(13, 0.75));
    		
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
    		addSequential(new DriveForwardCommand(-13, 0.75));
    		
    		// Turn back to facing forward
    		addSequential(new TurnToDegree(-45, 0.75));
    		
    		atSwitch = true;
    	
    	} else if (FMSInfo.charAt(1) == 'L'){
    		//Drive to scale
    		addSequential(new DriveForwardCommand(90, 0.75));
    		
    		//Turn To Angle better at scale
    		addSequential(new TurnToDegree(-45, 0.75));
    		
    		//go forward a bit
    		addSequential(new DriveForwardCommand(9, 0.75));
    		
    		//Turn back to scale
    		addSequential(new TurnToDegree(45, 0.75));
    		
    		//Drive To scale
    		addSequential(new DriveForwardCommand(75, 0.75));
    		
    		//Turn To Scale
    		addSequential(new TurnToDegree(95, 0.75));
    		
    		addSequential(new DriveForwardCommand(13, 0.75));
    		
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
    	else {
    		//Original
    		// Drive to the end of the first switch
        	addSequential(new DriveForwardCommand(113, 0.75));//or 81 if going for mid
    		addSequential(new DriveForwardCommand(30, .75));
        	// Turn the robot 90 degrees
        	addSequential(new TurnToDegree(90, 0.70));
        	
        	// Drive to the other side of the switch
        	addSequential(new DriveForwardCommand(185, 0.75));
        	
        	// Turn to face the switch
        	addSequential(new TurnToDegree(135, 0.70));
        	
        	//Drive Forward to Switch
        	addSequential(new DriveForwardCommand(20, 0.9));
        	
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
    		addSequential(new DriveForwardCommand(-20, 0.75));
    		
    		
    		addSequential(new DriveForwardCommand(30, 0.75));
    	}
    	
    	// If the scale side we're now closest to is also our color
    	if(FMSInfo.charAt(1) == 'L' && atSwitch) {
    		// TODO Attempt to score in scale
    		
    		} if (atSwitch && FMSInfo.charAt(1) == 'L') { //this for if we are not at the reverse side and we get the left side scale
    			// Drive to the end of the first switch
            	addSequential(new DriveForwardCommand(140, 0.75));//or 83
            	
            	// Turn the rear wheels towards the nearest cube
            	addSequential(new TurnToDegree(-35, 0.70));
            	
            	// Backup to get the cube and activate intake
	    		addSequential(new DriveForwardCommand(-35, 0.65));
	    		addParallel(new SetIntake(0.75));
	    		
	    		addSequential(new DriveForwardCommand(-20, 0.65));
	    		addParallel(new SetFlap(false));
	    			    		
	    		//Turn Slightly to add alignment to the scale
	    		addSequential(new TurnToDegree(10, 0.75));
	    		
	    		// Move away from the switch and toward scale 
	    		addSequential(new DriveForwardCommand(63, 0.7));//this distance is not set
	    		
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

