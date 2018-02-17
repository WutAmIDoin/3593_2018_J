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
    
    public static int IntakeL = 2;
    public static int IntakeR = 4;
    public static int SimR = 8;
    public static int SimL = 3;
    
    
	//Solenoid Channels
    public static int shifter = 4;
    public static int flap = 4;
    public static int booster = 4;
    public static int lift = 4;
    
    public static int Fold = 5;
    
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
    
    //Random Values
    public static double intakeIn = .75;
    public static double intakeOut = .8;
    
    //Axis Assignments
    public static int XBCintakein = 3;
    public static int XBCintakeout = 2;
    

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
    
    
    
    		
}
