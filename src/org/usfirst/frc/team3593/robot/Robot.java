package org.usfirst.frc.team3593.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team3593.robot.commands.*;

public class Robot extends TimedRobot 
{
	CommandGroup autoCommand = null;

	@Override
	public void robotInit() 
	{
		// Initializes all subsystems and the OI
		CommandBase.init();
	}
	
	@Override
	public void autonomousInit() {	
		// Grab auto mode from dashboard, default to BASEONLY
    	String autoMode = CommandBase.ntBehav.getEntry("autoMode").getString("BASEONLY");
    	System.out.println("Auto Mode set to " + autoMode);
    	
    	// TODO Get target info from vision
    	
    	String fieldInfo = DriverStation
				.getInstance().getGameSpecificMessage();
    	// If the FMS fieldData length is 0, try to get it again
    	if(fieldInfo.length() == 0) {
    		fieldInfo = DriverStation.getInstance().getGameSpecificMessage();
    	}
    	// If it's STILL 0, then just run baselineOnly to be safe
    	if(fieldInfo.length() == 0) {
    		autoMode = "BASEONLY";
    	}
    	
    	switch(autoMode) {
    	case "LEFT":
    		autoCommand = new CGAutoLeftSide(fieldInfo);
    		break;
    	case "RIGHT":
    		//rightSide();
    		break;
    	case "BASELEFT":
    		//baseline("L");
    		break;
    	case "BASERIGHT":
    		//baseline("R");
    		break;
    	case "BASEONLY":
		default:
			//baseline("");
			break;
    	}
    	
    	autoCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autoCommand != null)
            autoCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
}
