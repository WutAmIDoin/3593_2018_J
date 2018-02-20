/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3593.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3593.robot.commands.*;
import org.usfirst.frc.team3593.robot.subsystems.*;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	Command autoCommand = null;
	Command powerReporting = null;
	
	public static NetworkTable ntValues;
	public static NetworkTable ntVision;
	public static NetworkTable ntBehav;
	MjpegServer serv;
	UsbCamera rearCamera;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		CommandBase.init();
		
		//SmartDashboard Values
		SmartDashboard.putData(Scheduler.getInstance());
		
		//Left Auto
		SmartDashboard.putData("Run Left Auto LLL", new CGAutoLeftSide("LLL"));
		SmartDashboard.putData("Run Left Auto RLL", new CGAutoLeftSide("RLL"));
		SmartDashboard.putData("Run Left Auto LRL", new CGAutoLeftSide("LRL"));
		SmartDashboard.putData("Run Left Auto RRL", new CGAutoLeftSide("RRL"));
		
		//Right Auto
		SmartDashboard.putData("Run Right Auto LLL", new CGAutoLeftSide("LLL"));
		SmartDashboard.putData("Run Right Auto RLL", new CGAutoLeftSide("RLL"));
		SmartDashboard.putData("Run Right Auto LRL", new CGAutoLeftSide("LRL"));
		SmartDashboard.putData("Run Right Auto RRL", new CGAutoLeftSide("RRL"));
		
		//Run Commands
		SmartDashboard.putData("Toggle Folders", new ToggleFolderCommand());
		SmartDashboard.putData("Toggle Lifter", new ToggeLifterCommand());
		SmartDashboard.putData("Drive Forward 70in", new DriveForwardCommand(70, .75));
		SmartDashboard.putData("Turn 90 degrees", new TurnToDegree(90, .75));
		SmartDashboard.putData("Run Baseline", new CGAutoBaseline());
		
		//Network Tables
		Robot.ntValues = NetworkTableInstance.getDefault().getTable("3593-Values");
		Robot.ntVision = NetworkTableInstance.getDefault().getTable("3593-Vision");
		Robot.ntBehav = NetworkTableInstance.getDefault().getTable("3593-Behavior");
		Robot.ntBehav.getEntry("piContinue").setDefaultBoolean(true);
		Robot.ntBehav.getEntry("cameraView").setDefaultString("FRONT");
		Robot.ntBehav.getEntry("robotMode").setString("DISABLED");
		
		//Rear Camera
		serv = new MjpegServer("RearStream", 1188);
		rearCamera = new UsbCamera("RearCam", 0);
		rearCamera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 480, 20);
		serv.setSource(rearCamera);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		String autoMode = Robot.ntBehav.getEntry("autoMode").getString("BASEONLY");
    	System.out.println("Auto Mode set to " + autoMode);
    	
    	// TODO Get target info from vision
    	
    	String fieldInfo = DriverStation.getInstance().getGameSpecificMessage();
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
    		autoCommand = new CGAutoRightSide(fieldInfo);
    		break;
    	case "B-SWITCH": // turn to the vision target and drive to it, then score in switch
    		//baseline("R");
    		break;
    	case "BASEONLY": // break the baseline only, do not score
		default:
			autoCommand = new CGAutoBaseline();
			break;
    	}
    	
    	ntBehav.getEntry("robotMode").setString("AUTO");
    	autoCommand.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		ntBehav.getEntry("robotMode").setString("TELEOP");
	
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//Toggle Values
		SmartDashboard.putBoolean("Shifter Current Value", CommandBase.toggleShifters);
		SmartDashboard.putBoolean("Flap Current Value", CommandBase.toggleFlap);
		SmartDashboard.putBoolean("Lifter Current Value", CommandBase.toggleLifter);
		SmartDashboard.putBoolean("Folders Current Value", CommandBase.toggleFolders);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
