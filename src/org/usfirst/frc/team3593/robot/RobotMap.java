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
	
	//Random Values
	public static double shooterLowSpeed = .25;
	public static double shooterHighSpeed = .75;
	public static double intakeIn = .75;
	public static double intakeOut = .8;
	
	/*Subsystems
	 * New Subsystems:
Drive
Shifter
ShooterWheels
Launcher
Intake
Folder
Flap
Power
Vision
Lifter
Sensors
	 */
	
	/*Commands
	 * Commands:
RunIntake
AutoCommand
toggleFolders
ToggleLifter
ToggleShifters
ToggleFlap
Launch
ChargeShooter
ReportPower
DriveCommand
DashBoardUpdate
	 */
	
	
	
	}
