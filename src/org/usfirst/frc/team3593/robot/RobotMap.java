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
	public static int intakeFrontLeft = 2;
	public static int intakeFrontRight = 3;
	public static int intakeRearLeft = 4;
	public static int intakeRearRight = 8;
	// 7,9 reversed
	
	
	
	//5678
	//Solenoids:
	public static int shifter = 4;
	public static int booster = 5;
	public static int lifter = 6;
	public static int flap = 7; 
	public static int folders = 8;
	
	//analog
	public static int gyro = 3;
	public static int pressureSensor = 4;
	
	//DIO
	public static int encoderLeft1 = 0;
	public static int encoderLeft2 = 1;
	public static int encoderRight1 = 2;
	public static int encoderRight2 = 3;
	

	//stuffs
	public static double lowTrig = 0.25;
	public static double highTrig = 0.75;
	
	
	
}
