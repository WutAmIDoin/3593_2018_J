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
    	
    	//Preparations
    	//Shift and lower lifter and lift flap
    	addSequential(new SetShifter(false));
    	addSequential(new SetFlap(true));
    	addSequential(new BumpBackCommand());
    	
    	// Drive to the Corner of first switch and open intake arms
    	addSequential(new DriveForwardCommand(85, 0.85)); //or if 153 we go for the middle
    	addParallel(new SetFolders(true));
    	
//    	// If the left switch is our color
//    	if(FMSInfo.charAt(0) == 'L') { //Left Switch
//    		// Turn to face the switch
//    		addSequential(new TurnToDegree(45, 0.75));
//    		
//    		//Lower Lifter
//    		addSequential(new SetLifter(true));
//    		
//    		//Drive toward switch
//    		addSequential(new DriveForwardCommand(13, 0.9));
//    		
//    		//Score
//    		//Charge Motors
//    		addSequential(new SetShooter(RobotMap.switchSpeed));
//    		
//    		//Delay to get to speed
//    		addSequential(new DelayCommand(0.2));
//    		
//    		//Activate Launcher
//    		addSequential(new ActivateBoosterCommand());
//    		
//    		//Turn off shooters
//    		addSequential(new SetShooter(0));
//    		
//    		//Drive back and away
//    		addSequential(new DriveForwardCommand(-13, 0.85));
//    		
//    		// Turn back to facing forward
//    		addSequential(new TurnToDegree(-45, 0.75));
//    		
//    		atSwitch = true;
    	
//    	} 
	if (FMSInfo.charAt(1) == 'L'){ //Left Scale
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
	} else if (FMSInfo.charAt(0) == 'L') { //Left Switch
			// Turn to face the switch
			addSequential(new TurnToDegree(45, 0.70));
			
			//Lower Lifter
			addSequential(new SetLifter(true));
			
			//Drive toward switch
			addSequential(new DriveForwardCommand(13, 0.85));
			
			//Score
			//Charge Motors
			addSequential(new SetShooter(RobotMap.switchSpeed));
			
			//Delay to get to speed
			addSequential(new DelayCommand(0.2));
			
			//Activate Launcher
			addSequential(new ActivateBoosterCommand());
			
			//Turn off shooters
			addSequential(new SetShooter(0));
			
			//Drive back and away
			addSequential(new DriveForwardCommand(-13, 0.85));
			
			// Turn back to facing forward
			addSequential(new TurnToDegree(-45, 0.75));
	} else { //Opposite side switch
		
//    		addSequential(new DriveForwardCommand(70, 0.8));
//    	} //baseline code
			
			//Drive to center of scale/switch pathway
			addSequential(new DriveForwardCommand(165, 0.9));
			
			//Turn toward pathway
			addSequential(new TurnToDegree(90, 0.75));
			
			//Go down the pathway to the opposite switch
			addSequential(new DriveForwardCommand(155, 0.9));
			
			//Turn toward switch
			addSequential(new TurnToDegree(135, 0.75));
			
			//Drive to Switch
			addSequential(new DriveForwardCommand(35, 0.9));
			
			//Score
			//Charge Motors
			addSequential(new SetShooter(RobotMap.switchSpeed));
			
			//Delay to get to speed
			addSequential(new DelayCommand(0.2));
			
			//Activate Launcher
			addSequential(new ActivateBoosterCommand());
				
			//Turn off shooters
			addSequential(new SetShooter(0));
	  		
    	}
    	
    	// If the scale side we're now closest to is also our color
    	if(FMSInfo.charAt(1) == 'L' && atSwitch) {
    		// TODO Attempt to score in scale
    		
    		// Drive to the end of the first switch
           	addSequential(new DriveForwardCommand(140, 0.9));//or 83
           	
           	// Turn the rear wheels towards the nearest cube
           	addSequential(new TurnToDegree(-35, 0.75));
           	
           	// Backup to get the cube and activate intake
	    	addSequential(new DriveForwardCommand(-45, 0.9));
	    	addParallel(new SetIntake(0.75));
	    	
	    	addSequential(new DriveForwardCommand(-20, 0.65));
	    	addParallel(new SetFlap(false));
	    		    		
	    	addSequential(new DelayCommand(0.5));
	    	//Turn Slightly to add alignment to the scale
	    	addSequential(new TurnToDegree(10, 0.75));
	    		
	    	// Move away from the switch and toward scale 
	    	addSequential(new DriveForwardCommand(60, 0.9));//this distance is not set
	    
	    	//Stop the Intake
    		addSequential(new SetIntake(0));
	   		
	   		//Set the Lifter to UP
	   		addSequential(new SetLifter(false));
	   		
	    	// Turn toward the scale and shoot
            addSequential(new TurnToDegree(90, 0.75));//or 135
            	
    	
    		addSequential(new DelayCommand(0.2));
    		
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.scaleSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.2));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		}
	} 	
}

