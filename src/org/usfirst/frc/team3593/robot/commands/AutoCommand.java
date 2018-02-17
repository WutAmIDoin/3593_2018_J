package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;

public class AutoCommand extends CommandBase {

	private boolean finished = false;
	private String autoMode = "";
	private String fieldInfo = "";
	
    public AutoCommand(String FMS_DATA) {
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

    protected void initialize() {
    	
    	
    	
    	
    	
    	// Reset sensors for starting movement
    	sensors.resetGyro();
    	sensors.resetEncoderDistance();
    }

    
    protected void execute() {
    	
    	finished = true;
    }
    
    private void rightSide() {
    	boolean reverseScaleSide = false;
    	
    	// If the right switch is ALSO our color
    	if(fieldInfo.charAt(0) == 'R') {
    		// TODO Score in switch 
    	} else {
    		// TODO Drive around and score in other switch
    		reverseScaleSide = true;
    	}
    	
    	// If the switch we're now closest to is also our color
    	if(fieldInfo.charAt(1) == 'R' || reverseScaleSide) {
    		// TODO Attempt to pick up a cube and score in scale
    	}
    }

	private void baseline(String side) {
		// TODO Drive forward to the switch, breaking the baseline
		// OPTIONAL turn toward the first target seen
		
		// If fieldData is not empty AND this switch side is our color
		if(side != "" && fieldInfo.charAt(0) == side.toCharArray()[0]) {
			// TODO Score in the switch
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
