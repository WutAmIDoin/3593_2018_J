package org.usfirst.frc.team3593.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team3593.robot.commands.*;

public class Robot extends TimedRobot 
{
	CommandGroup autoCommand = null;
	
	// NetworkTables
	public static NetworkTable ntValues;
	public static NetworkTable ntVision;
	public static NetworkTable ntBehav;
	
	MjpegServer serv;
	UsbCamera rearCamera;

	@Override
	public void robotInit() 
	{
		// Initializes all subsystems and the OI
		CommandBase.init();
		
		Robot.ntValues = NetworkTableInstance.getDefault().getTable("3593-Values");
		Robot.ntVision = NetworkTableInstance.getDefault().getTable("3593-Vision");
		Robot.ntBehav = NetworkTableInstance.getDefault().getTable("3593-Behavior");
		Robot.ntBehav.getEntry("piContinue").setDefaultBoolean(true);
		Robot.ntBehav.getEntry("cameraView").setDefaultString("FRONT");
		Robot.ntBehav.getEntry("robotMode").setString("DISABLED");
		
		serv = new MjpegServer("RearStream", 1188);
		rearCamera = new UsbCamera("RearCam", 0);
		rearCamera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 480, 20);
		serv.setSource(rearCamera);
	}
	
	@Override
	public void autonomousInit() {	
		// Grab auto mode from dashboard, default to BASEONLY
    	String autoMode = Robot.ntBehav.getEntry("autoMode").getString("BASEONLY");
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
    	
    	switch(autoMode.toUpperCase()) {
    	case "LEFT":
    		autoCommand = new CGAutoLeftSide(fieldInfo);
    		break;
    	case "RIGHT":
    		//rightSide();
    		break;
    	case "B-SWITCH": // turn to the vision target and drive to it, then score in switch
    		//baseline("R");
    		break;
    	case "BASEONLY": // break the baseline only, do not score
		default:
			//baseline("");
			break;
    	}
    	
    	ntBehav.getEntry("robotMode").setString("AUTO");
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
		ntBehav.getEntry("robotMode").setString("TELEOP");
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		if(Timer.getMatchTime() <= 5) {
			// Shut down Pi gracefully 5 seconds before the end of a match
			ntBehav.getEntry("piContinue").setBoolean(false);
		}
	}
	
	@Override
	public void disabledInit() {
		ntBehav.getEntry("robotMode").setString("DISABLED");
	}
}
