package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class AutoCommand extends CommandBase {

	private boolean finished = false;
	private String autoMode = "";
	private String fieldInfo = "";
	
    public AutoCommand(String FMS_DATA) {
        // Use requires() here to declare subsystem dependencies
        requires(CommandBase.drive);
        requires(CommandBase.flap);
        requires(CommandBase.intakeArms);
        requires(CommandBase.intakeWheels);
        requires(CommandBase.launcher);
        requires(CommandBase.lifter);
        requires(CommandBase.shifter);
        requires(CommandBase.shooterWheels);
        requires(CommandBase.sensors);
        fieldInfo = FMS_DATA;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Grab auto mode
    	// Get target info from vision
    	// Get switch and scale colors
    }

    
    protected void execute() {
    	switch(autoMode) {
	    	case "LEFT":
	    		leftSide();
	    		break;
	    	case "RIGHT":
	    		rightSide();
	    		break;
	    	case "BASELEFT":
	    		baseline("L");
	    		break;
	    	case "BASERIGHT":
	    		baseline("R");
	    		break;
    		default:
    			baseline("");
    			break;
    	}
    	finished = true;
    }
    
    private void leftSide() {    	
    	boolean reverseScaleSide = false;
    	
    	// If the left switch is ALSO our color
    	if(fieldInfo.charAt(0) == 'L') {
    		// Score in switch 
    	} else {
    		// Go around and score in other switch
    		reverseScaleSide = true;
    	}
    	
    	// If the switch we're now closest to is also our color
    	if(fieldInfo.charAt(1) == 'L' || reverseScaleSide) {
    		// Attempt to score in scale
    	} 
    }
    
    private void rightSide() {
    	boolean reverseScaleSide = false;
    	
    	// If the right switch is ALSO our color
    	if(fieldInfo.charAt(0) == 'R') {
    		// Score in switch 
    	} else {
    		// Drive around and score in other switch
    		reverseScaleSide = true;
    	}
    	
    	// If the switch we're now closest to is also our color
    	if(fieldInfo.charAt(1) == 'R' || reverseScaleSide) {
    		// Attempt to pick up a cube and score in scale
    	}
    }

	private void baseline(String side) {
		// Drive forward to the switch, breaking the baseline
		
		if(side != "" && fieldInfo.charAt(0) == side.toCharArray()[0]) {
			// Score in the switch
		}
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.driveTank(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drive.driveTank(0, 0);
    }
}
