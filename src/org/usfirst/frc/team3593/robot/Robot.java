
package org.usfirst.frc.team3593.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3593.robot.commands.*;


public class Robot extends TimedRobot {
	
	Command autoCommand = null;	
	Command powerReporting = null;
	
	// NetworkTables
	public static NetworkTable ntValues;
	public static NetworkTable ntVision;
	public static NetworkTable ntBehav;
	
	MjpegServer serv;
	UsbCamera rearCamera;
	
	@Override
	public void robotInit() {
		CommandBase.init();
		
		//SmartDashboard Values

				SmartDashboard.putData(Scheduler.getInstance());			
//				//Left Auto
//				SmartDashboard.putData("Run Left Auto LLL", new CGAutoLeftSide("LLL"));
//				SmartDashboard.putData("Run Left Auto RLL", new CGAutoLeftSide("RLL"));
//				SmartDashboard.putData("Run Left Auto LRL", new CGAutoLeftSide("LRL"));
//				SmartDashboard.putData("Run Left Auto RRL", new CGAutoLeftSide("RRL"));
//				//Right Auto
//				SmartDashboard.putData("Run Right Auto LLL", new CGAutoLeftSide("LLL"));
//				SmartDashboard.putData("Run Right Auto RLL", new CGAutoLeftSide("RLL"));
//				SmartDashboard.putData("Run Right Auto LRL", new CGAutoLeftSide("LRL"));
//				SmartDashboard.putData("Run Right Auto RRL", new CGAutoLeftSide("RRL"));			
//				//Run Commands
//				SmartDashboard.putData("Toggle Folders", new ToggleFolderCommand());
//				SmartDashboard.putData("Toggle Lifter", new ToggeLifterCommand());
//				SmartDashboard.putData("Drive Forward 100in", new DriveForwardCommand(50, .75));
//				SmartDashboard.putData("Turn 90 degrees", new TurnToDegree(90, .5));
//				SmartDashboard.putData("Run Baseline", new CGAutoBaseline());
				
		Robot.ntValues = NetworkTableInstance.getDefault().getTable("3593-Values");
    	Robot.ntVision = NetworkTableInstance.getDefault().getTable("3593-Vision");
    	Robot.ntBehav = NetworkTableInstance.getDefault().getTable("3593-Behavior");
    	Robot.ntBehav.getEntry("piContinue").setDefaultBoolean(true);
		Robot.ntBehav.getEntry("cameraView").setDefaultString("FRONT");
		Robot.ntBehav.getEntry("robotMode").setString("DISABLED");
		
		serv = new MjpegServer("RearStream", 1188);
        rearCamera = new UsbCamera("RearCam", 0);
        rearCamera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 480, 15);
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
    	
    	autoCommand = new CGAutoRightSide(fieldInfo);
    	Robot.ntBehav.getEntry("robotMode").setString("AUTO");
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
		Robot.ntBehav.getEntry("robotMode").setString("TELEOP");
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Shifter Current Value", CommandBase.toggleShifter);
		SmartDashboard.putBoolean("Flap Current Value", CommandBase.toggleFlap);
		SmartDashboard.putBoolean("Lifter Current Value", CommandBase.toggleLifter);
		SmartDashboard.putBoolean("Folders Current Value", CommandBase.toggleFolder);
	}
	
	@Override
	public void disabledInit() {
		Robot.ntBehav.getEntry("robotMode").setString("DISABLED");
	}
}