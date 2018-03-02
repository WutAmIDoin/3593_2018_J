/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3593.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//PWM Channels
	public static int driveLeftPWM = 1;
	public static int driveRightPWM = 0;
	public static int shooterLFront = 5;
	public static int shooterLRear = 6;
	public static int shooterRFront = 7;
	public static int shooterRRear = 9;
	public static int intakeL = 2;
	public static int intakeR = 4;
	public static int ciminiR = 8;
	public static int ciminiL = 3;
	
	//PCM Channel
	public static int shifters = 4;
	public static int booster = 7;
	public static int flap = 0;
	public static int lift = 6;
	public static int folder = 5;
	
	//DIO Channels
	public static int encoderL1 = 0;
	public static int encoderL2 = 1;
	public static int encoderR1 = 2;
	public static int encoderR2 = 3;
	
	//Analog Channels
	public static int gryo = 0;
	public static int pressureSensor = 1;
	
	//Power Channels
	public static int pdp_driveRight1 = 1;
	public static int pdp_driveRight2 = 14;
	public static int pdp_driveLeft1 = 0;
	public static int pdp_driveLeft2 = 15;
	public static int pdp_shooterRight1 = 12;
	public static int pdp_shooterRight2 = 13;
	public static int pdp_shooterLeft1 = 2;
	public static int pdp_shooterLeft2 = 3;
	public static int pdp_IntakeLeft = 5;
	public static int pdp_IntakeRight = 11;
	public static int pdp_cimmy1 = 4;
	public static int pdp_cimmy2 = 10;
	
	//Random Values
	public static double shooterLowSpeed = 0.25;
	public static double shooterHighSpeed = 1;
	public static double intakeIn = 0.8;
	public static double intakeOut = 0.8;
	
	public static double wheelDiameter = 6;
	public static double encoderPPR = 256;
	
	//Axis Assignments
	public static int XBC1intakein = 3;
	public static int XBC1intakeout = 2;
	public static int XBC1driveleft = 1;
	public static int XBC1driveright = 5;
	
	public static int XBC2shooterlow = 2;
	public static int XBC2shooterhigh = 3;
	
	//PID Values
	public static double driveKp = 0.05;
	
	// Gyro / Turn PID values
	public static double gyroKp = 0.01;
	public static double gyroPIDTolerance = 5; // This is a percent
		
	// Speeds and other values
	public static double switchSpeed = 0.5;
	public static double scaleSpeed = 1;	
	
	}
