package org.usfirst.frc.team3593.robot.subsystems;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraSubsystem extends Subsystem {
	
	MjpegServer server;
	UsbCamera rearCam;
	
	public CameraSubsystem() {
		server = new MjpegServer("RearStream", 1118);
		rearCam = new UsbCamera("RearCamera", 0);
		rearCam.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 480, 15);
		server.setSource(rearCam);
	}  
    public void initDefaultCommand() {
        //setDefaultCommand(new StartCamera());
    }
}

