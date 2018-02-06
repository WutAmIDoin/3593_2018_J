/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3593.robot;


public class RobotMap {
	// PWM Channels
	public static int driveLeftpwm = 1;
	public static int driveRIghtpwm = 0;
	
	public static int shooterFrontL = 5;
    public static int shooterRearL = 6;
    public static int shooterFrontR = 7;
    public static int shooterRearR = 9;
    
	//Solenoid Channels
    public static int shifter = 4;
    public static int flap = 4;
    public static int booster = 4;
    public static int lift = 4;
    
    // Analog Channel
    public static int gyro = 3;
    public static int pressuresensor = 2;
    
    //Digital channel
    public static int leftencoder1 = 0;
    public static int Leftencoder2 = 1;
    public static int Rightencoder1 = 2;
    public static int Rightencoder2 = 3;
    
    //Values
    public static double LowTrig = 0.25;
    public static double HighTrig = 0.75;
    		
}
