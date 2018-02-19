/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3593.robot;


public class RobotMap {
	
	
	//PWMs
	public static int driveLeftPWM = 1;
	public static int driveRightPWM = 0;
	public static int shooterFrontLeft = 5;
	public static int shooterRearLeft = 6;
	public static int shooterFrontRight = 7;
	public static int shooterRearRight = 9;
	public static int intakeL = 2;
	public static int intakeR = 4;
	public static int cimL = 3;
	public static int cimR = 8;
	// 7,9 reversed
	
	//Solenoids:
	public static int shifter = 4;
	public static int booster = 7;
	public static int lifter = 6;
	public static int flap = 0; 
	public static int folder = 5;
	
	//analog
	public static int gyro = 0;
	public static int pressureSensor = 1;
	
	//DIO
	public static int encL1 = 0;
	public static int encL2 = 1;
	public static int encR1 = 2;
	public static int encR2 = 3;
	
	// Power channels
	public static int pdp_driveLeft1 = 0;
	public static int pdp_driveLeft2 = 15;
	public static int pdp_driveRight1 = 1;
	public static int pdp_driveRight2 = 14;
	public static int pdp_shooterRight1 = 12;
	public static int pdp_shooterRight2 = 13;
	public static int pdp_shooterLeft1 = 2;
	public static int pdp_shooterLeft2 = 3;
	public static int pdp_IntakeLeft = 5;
	public static int pdp_IntakeRight = 11;
	public static int pdp_cimmy1 = 4;
	public static int pdp_cimmy2 = 10;
	
	
	
	//stuffs
	public static double lowTrig = 0.5;
	public static double highTrig = 1;
	
	public static double takeIn = 0.8;
	public static double takeOut = -0.8;
	
	
	
	//controller stuffs
	public static int XBC1takein = 3;
	public static int XBC1takeout = 2;
	public static int XBC1driveleft = 1;
	public static int XBC1driveright = 5;
	public static int XBC1toggleShifter = 5;
	
	public static int XBC2lowtrig = 2;
	public static int XBC2hightrig = 3;
	
	// activateLauncher - launch cube into shooter wheels
	public static int XBC2activateLauncher = 1;
	public static int XBC2toggleLifter = 3;
	public static int XBC2toggleFlap = 5;
	
	
	
	// sensor and vision stuff
	public static double wheelDiameter = 6;
	public static double encoderPPR = 256;
	public static double encoderDPP = (wheelDiameter*Math.PI)/encoderPPR;
	
	
	// Drive PID values
	public static double driveKp = 0;
	public static double driveKi = 0;
	public static double driveKd = 0;
	public static double drivePIDTolerance = 5; // This is a percent

	
	// Gyro / Turn PID values
	public static double gyroKp = 0;
	public static double gyroKi = 0;
	public static double gyroKd = 0;
	public static double gyroPIDTolerance = 5; // This is a percent

	
	
	// values for auto
	public static double switchSpeed = 0.25;
	public static double scaleSpeed = 1;
	
	
	
	// Problems:
	// CG Auto
	// Robot.Java
	// PID
	// Turn to Degree? DriveForwardDistance?; LaunchCube
	//
	// flap before folder
 
}
