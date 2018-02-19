package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.commands.StartCamera;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.command.Subsystem;


public class CameraSubsystem extends Subsystem {

	MjpegServer serv;
	UsbCamera rearCamera;

    public CameraSubsystem() {
        serv = new MjpegServer("RearStream", 1188);
        rearCamera = new UsbCamera("RearCam", 0);
        rearCamera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 480, 15);
        serv.setSource(rearCamera);
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new StartCamera());
    }
}

