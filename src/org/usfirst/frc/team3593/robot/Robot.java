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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.zeromq.*;

import org.json.JSONException;
import org.json.JSONObject;

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
	
	MjpegServer serv;
	UsbCamera rearCamera;
	
	ZMQ.Context context;
	ZMQ.Socket responder;
	
	@Override
	public void robotInit() {
		CommandBase.init();
		
		//toggles
		CommandBase.dashTable.put("intakeArms", 0);
		CommandBase.dashTable.put("shooterPosition", 0);
		CommandBase.dashTable.put("driveShifter", 0);
		CommandBase.dashTable.put("flapPosition", 0);
		
		//Sensors
		CommandBase.dashTable.put("driveLeftEncoder", 0);
		CommandBase.dashTable.put("driveRightEncoder", 0);
		CommandBase.dashTable.put("gyroAngle", 0);
		CommandBase.dashTable.put("systemPressure", 0);
		
		//Power
		CommandBase.dashTable.put("battVoltage", 0);
		// Get total current of the PDP
		CommandBase.dashTable.put("totalCurrent", 0);
		
		CommandBase.dashTable.put("driveRight1", 0);
		CommandBase.dashTable.put("driveRight2", 0);
		CommandBase.dashTable.put("driveLeft1", 0);
		CommandBase.dashTable.put("driveLeft2", 0);
		CommandBase.dashTable.put("shooterRight1", 0);
		CommandBase.dashTable.put("shooterRight2", 0);
		CommandBase.dashTable.put("shooterLeft1", 0);
		CommandBase.dashTable.put("shooterLeft2", 0);
		CommandBase.dashTable.put("IntakeLeft", 0);
		CommandBase.dashTable.put("IntakeRight", 0);
		CommandBase.dashTable.put("cimmy1", 0);
		CommandBase.dashTable.put("cimmy2", 0);
		
		//SmartDashboard Values
		SmartDashboard.putData(Scheduler.getInstance());

		//Rear Camera
		serv = new MjpegServer("RearStream", 1188);
		rearCamera = new UsbCamera("RearCam", 0);
		rearCamera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 480, 30);
		serv.setSource(rearCamera);
		
		//TommiNET
		CommandBase.dashTable = new JSONObject();
        CommandBase.dashTable.put("gyroAngle", 0);
        CommandBase.dashTable.put("autoMode", "NOT SET");
        
        context = ZMQ.context(1);

        //  Socket to talk to clients
        responder = context.socket(ZMQ.REP);
        responder.bind("tcp://*:1180");
        DriverStation.reportWarning("Binding socket", false);
        
        Thread t = new Thread(() -> {
        	while(!Thread.interrupted()) {
                byte[] request = responder.recv(8);
                CommandBase.dashTable.put("autoMode", new 
                		String(request));
                //System.out.println(new String(request));

                // Send reply back to client
                String reply = CommandBase.dashTable.toString();
                responder.send(reply.getBytes(), 0);
                Timer.delay(0.2);
        	}
        });
        t.start();
        System.out.println("RobotStarted");
        CommandBase.dashTable.put("robotMode", "DISABLED");
	}

	@Override
	public void disabledInit() {
        CommandBase.dashTable.put("robotMode", "DISABLED");
	}

	@Override
	public void disabledPeriodic() {
		
	}

	@Override
	public void autonomousInit() {
        CommandBase.dashTable.put("robotMode", "AUTO");
		String autoMode = CommandBase.dashTable.getString("autoMode");
        System.out.println("Auto Mode set to " + autoMode);
    	
		String fieldInfo = DriverStation.getInstance().getGameSpecificMessage();
		
    	//If the FMS fieldData length is 0, try to get it again
    	if(fieldInfo.length() == 0) {
    		fieldInfo = DriverStation.getInstance().getGameSpecificMessage();
    	}
    	// If it's STILL 0, then just run baselineOnly to be safe
    	if(fieldInfo.length() == 0) {
    		autoMode = "BASEONLY";
    	}
   	
    	switch(autoMode.toUpperCase()) {
	    	case "LEFT":
	    	default:
	    		autoCommand = new CGAutoLeftSide(fieldInfo);
	    		System.out.println("AUTO - Set to LEFT");
	    		break;
	    	case "RIGHT":
	    		autoCommand = new CGAutoRightSide(fieldInfo);
	    		System.out.println("AUTO - Set to RIGHT");
	    		break;
	    	case "BASELEFT": //Currently Middle
	    		autoCommand = new CGAutoBaseline(fieldInfo, "L");
	    		System.out.println("AUTO - Set to BASELEFT");
	    		break;
	    	case "BASERIGHT": //Currently Middle
				autoCommand = new CGAutoBaseline(fieldInfo, "R");
				System.out.println("AUTO - Set to BASERIGHT");
				break;
	    	case "CENTER": 
	    		autoCommand = new CGAutoMiddle(fieldInfo);
	    		System.out.println("AUTO - Set to MIDDLE");
	    		break;
	    	case "SCALEONLYL":
	    		autoCommand = new CGScaleOnlyL(fieldInfo);
	    		System.out.println("AUTO - Set to SCALEONLY L");
	    		break;
	    }
    	autoCommand.start();
    	System.out.println(">>> AUTO - Running " + autoMode.toUpperCase());
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
        CommandBase.dashTable.put("robotMode", "TELEOP");
		if (autoCommand != null) {
			autoCommand.cancel();
		}
	
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
