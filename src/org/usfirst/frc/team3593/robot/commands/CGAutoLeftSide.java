package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAutoLeftSide extends CommandGroup {

    public CGAutoLeftSide(String FMSInfo) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	// PLAN--------------------------
    	boolean reverseScaleSide = false;
    	
    	// Drive to the first switch
    	addSequential(new DriveDistanceForward(120, 0.75));
    	// Open the intake arms
    	addParallel(new SetIntakeArms(true));
    	
    	// If the left switch is our color
    	if(FMSInfo.charAt(0) == 'L') {
    		// Turn to face the switch
    		addSequential(new TurnToDegree(-45, 0.50));
    		
    		// Score in switch
    		addSequential(new SetShooterSpeed(RobotMap.switchSpeed));
    		addSequential(new LaunchCube());
    		
    		// Turn back to facing forward
    		addSequential(new TurnToDegree(45, 0.50));
    	} else {
    		// Drive to the end of the first switch
        	addSequential(new DriveDistanceForward(160, 0.75));
        	
        	// Turn the robot 90 degrees
        	addSequential(new TurnToDegree(-90, 0.50));
        	
        	// Drive to the other side of the switch
        	addSequential(new DriveDistanceForward(140, 0.75));
        	
        	// Turn to face the switch
        	addSequential(new TurnToDegree(-90, 0.50));
        	
        	// Score in the switch
        	addSequential(new SetShooterSpeed(RobotMap.switchSpeed));
        	addSequential(new LaunchCube());
        	
    		reverseScaleSide = true;
    	}
    	
    	// If the scale side we're now closest to is also our color
    	if(FMSInfo.charAt(1) == 'L' || reverseScaleSide) {
    		// TODO Attempt to score in scale
    		if(reverseScaleSide)
    		{
	    		// Turn around to get a cube
	    		addParallel(new SetIntakeSpeed(0.75));
	    		addSequential(new TurnToDegree(180, 0.50));
	    		
	    		// Backup to get the cube
	    		addSequential(new DriveDistanceForward(-6, -0.25));
	    		
	    		// Move forward a distance and score
	    		addSequential(new DriveDistanceForward(10, 0.5));
    		} else {
    			// Drive to the end of the first switch
            	addSequential(new DriveDistanceForward(160, 0.75));
            	
            	// Turn the rear wheels towards the nearest cube
            	addSequential(new TurnToDegree(45, 0.50));
            	
            	// Backup to get the cube
            	addParallel(new SetIntakeSpeed(0.75));
	    		addSequential(new DriveDistanceForward(-16, -0.25));
	    		
	    		// Move away from the switch
	    		addSequential(new DriveDistanceForward(10, 0.5));
	    		
	    		// Turn toward the scale
            	addSequential(new TurnToDegree(45, 0.50));
            	
            	// Move toward the scale
	    		addSequential(new DriveDistanceForward(10, 0.5));
    		}
    		
    		// SCORE
    		addSequential(new SetShooterSpeed(RobotMap.scaleSpeed));
        	addSequential(new LaunchCube());
    	} 
    	
    	// Fin
    }
}
