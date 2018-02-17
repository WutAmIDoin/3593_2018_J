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
    		// TODO turn to face the switch
    		addSequential(new SetShooterSpeed(RobotMap.switchSpeed));
    		addSequential(new LaunchCube());
    	} else {
    		// TODO Go around and score in other switch
    		// Drive to the end of the first switch
        	addSequential(new DriveDistanceForward(140, 0.75));
        	// Turn the robot 90 degrees
        	// Drive to the other side of the switch
        	// Score in the switch
        	addSequential(new SetShooterSpeed(RobotMap.switchSpeed));
        	
    		reverseScaleSide = true;
    	}
    	
    	// If the switch we're now closest to is also our color
    	if(FMSInfo.charAt(1) == 'L' || reverseScaleSide) {
    		// TODO Attempt to score in scale
    	} 
    	
    	
    	
    }
}
