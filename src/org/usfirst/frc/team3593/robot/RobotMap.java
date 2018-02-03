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
	// PWM Channels
	public static int driveLeftPWM = 1;
	public static int driveRightPWM = 0;
	
	public static int shooterFrontLeft = 5;
	public static int shooterRearLeft = 6;
	public static int shooterFrontRight = 7;
	public static int shooterRearRight = 9;
	
	// Solenoid Channels
	public static int shifterSolendoidChannel = 4;
	public static int boosterSolenoidChannel = 5;
	public static int lifterSolenoidChannel = 6;
	public static int flapSolenoidChannel = 7;
	
	// Analog Channels
	public static int gyroChannel = 3;
	public static int pressureSensorChannel = 4;
	
	// Digital Channels
	public static int leftEncoder1 = 0;
	public static int leftEncoder2 = 1;
	public static int rightEncoder1 = 2;
	public static int rightEncoder2 = 3;
	
}
