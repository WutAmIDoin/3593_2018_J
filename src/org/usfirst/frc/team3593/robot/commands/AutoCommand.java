package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;


public class AutoCommand extends CommandBase {

	private boolean finished = false;
	private String autoMode = "";
	private String fieldInfo = "";
	
    public AutoCommand(String FMS_DATA) {
        requires(CommandBase.theDrive);
        requires(CommandBase.theFlap);
        requires(CommandBase.theFolder);
        requires(CommandBase.theLifter);
        requires(CommandBase.theShifter);
        requires(CommandBase.theShooter);
        requires(CommandBase.theBooster);
        requires(CommandBase.theIntake);
        requires(CommandBase.theSensor);
        fieldInfo = FMS_DATA;
    }


    protected void initialize() {
    	// Grab auto mode from dashboard? Default to BASEONLY??
    	autoMode = CommandBase.ntBehav.getEntry("autoMode").getString("BASEONLY");
    	System.out.println("Auto Mode set to " + autoMode);
    	
    	// TODO get target info from vision
    	
    	// If the FMS fieldData length is 0, try to get it again.
    	if(fieldInfo.length() == 0) {
    		fieldInfo = DriverStation.getInstance().getGameSpecificMessage();
    	}
    	// If it's still 0, then just run baselineOnly to be safe. 
    	if(fieldInfo.length() == 0) {
    		autoMode = "BASEONLY";
    	}
    	
    	// Reset sensors for starting movement
    	theSensor.resetGyro();
    	theSensor.resetEncoders();    	
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
    	case "BASEONLY":
    	default:
    		baseline("");
    		break;
    	}
    	finished = true;
    }
    
    
    private void leftSide() {
    	boolean reverseScaleSide = false;
    	
    	// If the left switch is also our color;
    	if(fieldInfo.charAt(0) == 'L') {
    		// TODO score in switch
    	}else {
    		// TODO go around and score in other switch
    		reverseScaleSide = true;
    	}
    	
    	// If the switch we are now closest to is our color
    	if (fieldInfo.charAt(1) == 'L' || reverseScaleSide) {
    		// TODO attempt to score in scale
    	}
    }
    
    
    private void rightSide() {
    	boolean reverseScaleSide = false;
    	
    	// If the right switch is also our color;
    	if(fieldInfo.charAt(0) == 'R') {
    		// TODO score in switch
    	}else {
    		// TODO drive around and score in other switch
    		reverseScaleSide = true;
    	}
    	
    	// If the switch we are now closest to is our color
    	if(fieldInfo.charAt(1) == 'R' || reverseScaleSide) {
    		// TODO attempt to pick up a cube and score in scale
    	}
    }
    
    private void baseline(String side) {
    	// TODO drive forward to the switch, breaking the baseline
    	// OPTIONAL turn toward the first target seen
    	
    	// If fieldData is not empty AND this switch side is our color
    	if (side != "" && fieldInfo.charAt(0) == side.toCharArray()[0]) {
    		// TODO score in the switch
    	}
    }


    protected boolean isFinished() {
        return finished;
    }


    protected void end() {
    	theDrive.driveTank(0, 0);
    }

    
    protected void interrupted() {
    	theDrive.driveTank(0, 0);
    }
}
