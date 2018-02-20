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
	// Encoder variables
	public static int wheelDiam = 6;
	public static int encoderTicks = 256;
	
	// PWM Channels
	public static int driveLeftPWM = 1;
	public static int driveRightPWM = 0;
	
	public static int shooterFrontLeft = 5;
	public static int shooterRearLeft = 6;
	public static int shooterFrontRight = 7;
	public static int shooterRearRight = 9;
	
	public static int intakeLeft1 = 2;
	public static int intakeLeft2 = 3;
	public static int intakeRight1 = 4;
	public static int intakeRight2 = 8;
	
	// Solenoid Channels
	public static int shifterSolendoidChannel = 4;
	public static int boosterSolenoidChannel = 7;
	public static int lifterSolenoidChannel = 6;
	public static int flapSolenoidChannel = 0;
	public static int intakeArmsSolenoidChannel = 5;
	
	// Analog Channels
	public static int gyroChannel = 0;
	public static int pressureSensorChannel = 1;
	
	// Digital Channels
	public static int leftEncoder1 = 0;
	public static int leftEncoder2 = 1;
	public static int rightEncoder1 = 2;
	public static int rightEncoder2 = 3;
	
	// Power channels
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
	
	// Joystick Values
	public static double trigDeadzone = 0.15;
	public static boolean driveReversed = false;
	
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
	
	// Speeds and other values
	public static double switchSpeed = 0.25;
	public static double scaleSpeed = 1;
	
	/*Subsystems
		> Drive
		> Shifter
		> ShooterWheels
		> Launcher
		> IntakeWheels
		> IntakeArms
		> Flap
		> PowerReporting
		Network
		> Lifter
		> Sensors
	 */
	
	/*Commands
	 	> DriveCommand (never ending)
		> RunIntake (never ending)
		AutoCommand (later)
		> ToggleArmPosition
		> ToggleLifter
		> ToggleShifters
		> ToggleFlap
		> Launch
		ChargeShooter (never ending)
		ReportPower (never ending)
		DashBoardUpdate (never ending)
	 */
}
