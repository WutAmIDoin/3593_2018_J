package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.*;

import edu.wpi.first.wpilibj.Timer;
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
    	
    	//Shift and lower lifter
    	addSequential(new SetShifter(false));
    	addSequential(new SetLifter(true));
    	
    	// Drive to the first switch
    	addSequential(new DriveForwardCommand(110, 0.75)); //or if 153 we go for the middle
    	// Open the intake arms
    	addParallel(new SetFolders(true));
    	
    	// If the left switch is our color
    	if(FMSInfo.charAt(0) == 'L') {
    		// Turn to face the switch
    		addSequential(new TurnToDegree(-45, 0.50));
    		
    		// Score in switch
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		Timer.delay(4);
    		addSequential(new ActivateBoosterCommand());
    		//Stop Motors
    		addSequential(new SetShooter(0));
    		
    		// Turn back to facing forward
    		addSequential(new TurnToDegree(45, 0.50));
    	} else {
    		// Drive to the end of the first switch
        	addSequential(new DriveForwardCommand(110, 0.75));//or 81 if going for mid
        	
        	// Turn the robot 90 degrees
        	addSequential(new TurnToDegree(-90, 0.50));
        	
        	// Drive to the other side of the switch
        	addSequential(new DriveForwardCommand(155, 0.75));
        	
        	// Turn to face the switch
        	addSequential(new TurnToDegree(-90, 0.50));
        	
        	// Score in the switch
        	addSequential(new SetShooter(RobotMap.switchSpeed));
        	Timer.delay(2);
        	addSequential(new ActivateBoosterCommand());
        	//Stop Motors
        	addSequential(new SetShooter(0));
    		reverseScaleSide = true;
    	}
    	
    	// If the scale side we're now closest to is also our color
    	if(FMSInfo.charAt(1) == 'L' || reverseScaleSide) {
    		// TODO Attempt to score in scale
    		if(reverseScaleSide)
    		{
	    		// Turn around to get a cube
	    		addParallel(new SetIntake(0.75));
	    		addSequential(new TurnToDegree(180, 0.50));
	    		
	    		// Backup to get the cube
	    		addSequential(new DriveForwardCommand(-10, -0.25));
	    		
	    		//Back Away from switch
	    		addSequential(new DriveForwardCommand(10, 0.5));
	    		
	    		//Turn towards scale and stop intake
	    		addSequential(new TurnToDegree(45, 0.5));
	    		addParaellel(new SetIntake(0));
	    		
	    		//Drive to Scale
	    		addSequential(new DriveForwardCommand(40, 0.75));
	    		
	    		//Turn to shoot
	    		addSequential(new TurnToDegree(-45, 0.5));
    		
    		} else {
    			// Drive to the end of the first switch
            	addSequential(new DriveForwardCommand(112, 0.75));//or 83
            	
            	// Turn the rear wheels towards the nearest cube
            	addSequential(new TurnToDegree(45, 0.50));
            	
            	// Backup to get the cube
            	addParallel(new SetIntake(0.75));
	    		addSequential(new DriveForwardCommand(-12, -0.25));
	    		
	    		// Move away from the switch and toward scale 
	    		addSequential(new DriveForwardCommand(45, 0.5));//this distance is not set
	    		addSequential(new SetIntake(0));
	    		
	    		// Turn toward the scale and shoot
            	addSequential(new TurnToDegree(90, 0.50));//or 135
    		}
    		
    		// SCORE
    		addSequential(new SetShooter(RobotMap.scaleSpeed));
    		Timer.delay(2);
        	addSequential(new ActivateBoosterCommand());
        	Timer.delay(0);
        	addSequential(new SetShooter(0));
    	} 
    	
    	// Fin
    }
}
