package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAutoRightSide extends CommandGroup {

    public CGAutoRightSide(String FMSInfo) {    	
    	// PLAN--------------------------
    	boolean reverseScaleSide = false;
    	boolean shoot = false;
    	
    	//Preparations
    	//Shift and Lower Lifter and lower Flap
    	addSequential(new SetShifter(false));
    	addSequential(new SetLifter(true));
    	addSequential(new SetFlap(true));
    	
    	// Drive to the corner of the first switch and open intake
    	addSequential(new DriveForwardCommand(100, 0.75));
    	addParallel(new SetFolders(true));
    	
    	// If the right switch is our color
    	if(FMSInfo.charAt(0) == 'R') {
    		// Turn to face the switch
    		addSequential(new TurnToDegree(-45, 0.70));
    		
    		//Drive towards the Switch
    		addSequential(new DriveForwardCommand(10, 0.75));
    		
    		// Score in switch
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.5));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//Back away from switch
    		addSequential(new DriveForwardCommand(-10, 0.75));
    		
    		// Turn back to facing forward
    		addSequential(new TurnToDegree(45, 0.7));
    		
    	} else {
    		// Drive to the end of the first switch
        	addSequential(new DriveForwardCommand(110, 0.75));//or 81
        	
        	// Turn the robot 90 degrees
        	addSequential(new TurnToDegree(-90, 0.7));
        	
        	// Drive to the other side of the switch
        	addSequential(new DriveForwardCommand(155, 0.75));
        	
        	// Turn to face the switch
        	addSequential(new TurnToDegree(-90, 0.70));
        	
        	//Drive toward the Switch
        	addSequential(new DriveForwardCommand(15, 0.65));
        	
        	//Shoot
        	//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Delay to get to speed
    		addSequential(new DelayCommand(0.5));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//Back away from the Switch
    		addSequential(new DriveForwardCommand(-15, 0.75));
    		
    		reverseScaleSide = true;
    	}
    	
    	// If the scale side we're now closest to is also our color
    	if(FMSInfo.charAt(1) == 'R' || reverseScaleSide) {
    		// TODO Attempt to score in scale
    		if(reverseScaleSide && FMSInfo.charAt(1) == 'L')
    		{
	    		// Turn around to get a cube and set intake
	    		addSequential(new TurnToDegree(180, 0.70));
	    		addParallel(new SetIntake(0.75));
	    		
	    		// Backup to get the cube
	    		addSequential(new DriveForwardCommand(-15, 0.5));
	    		
	    		//Back Away from switch
	    		addSequential(new DriveForwardCommand(15, 0.5));
	    		
	    		//Turn towards scale and stop Intake
	    		addSequential(new TurnToDegree(-45, 0.7));
	    		addParallel(new SetIntake(0));
	    		
	    		//Drive to Scale
	    		addSequential(new DriveForwardCommand(30, 0.75));
	    		
	    		//Set Lifter UP
	    		addSequential(new SetLifter(false));
	    		
	    		//Turn to shoot
	    		addSequential(new TurnToDegree(-90, 0.7));
	    		
	    		shoot = true;
    		
    		} else if (FMSInfo.charAt(1) == 'R') {
    			// Drive to the end of the first switch
            	addSequential(new DriveForwardCommand(100, 0.75));
            	
            	// Turn the rear wheels towards the nearest cube
            	addSequential(new TurnToDegree(45, 0.7));
            	
            	// Backup to get the cube while activating intake
	    		addSequential(new DriveForwardCommand(-12, 0.7));
	    		addParallel(new SetIntake(0.75));
	    		
	    		//Turn Slightly to line up with scale
	    		addSequential(new TurnToDegree(10));
	    		
	    		// Move away from the switch and toward scale and stop intake
	    		addSequential(new DriveForwardCommand(45, 0.5));//this distance is not set
	    		addParallel(new SetIntake(0));
	    		
	    		//Set Lifter UP
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
