
package org.usfirst.frc.team3593.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team3593.robot.commands.*;


public class Robot extends TimedRobot {
	
	Command autoCommand = null;	
	
	@Override
	public void robotInit() {
		CommandBase.init();
		CommandBase.ntBehav.getEntry("robotMode").setString("DISABLED");
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
    		autoCommand = new CGAutoRightSide(fieldInfo);
    		break;
    	case "BASELEFT":
    		autoCommand = new CGAutoBaseLeft();
    		break;
    	case "BASERIGHT":
    		autoCommand = new CGAutoBaseRight();
    		break;
    	case "BASEONLY":
		default:
			//baseline("");
			break;
    	}
    	
    	CommandBase.ntBehav.getEntry("robotMode").setString("AUTO");
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
		CommandBase.ntBehav.getEntry("robotMode").setString("TELEOP");
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void disabledInit() {
		CommandBase.ntBehav.getEntry("robotMode").setString("DISABLED");
	}
}