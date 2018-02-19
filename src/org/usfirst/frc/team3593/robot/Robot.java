/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3593.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3593.robot.commands.*;


public class Robot extends TimedRobot {
Command autoCommand = null;
Command powerReporting = null;


Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		CommandBase.init();
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		autoCommand = new AutoCommand(DriverStation
				.getInstance().getGameSpecificMessage());
		autoCommand.start();
		
	}

	@Override 
	 	public void autonomousPeriodic() { 
	 		Scheduler.getInstance().run(); 
	 	} 
	 
		 	@Override 
	 	public void teleopInit() { 
	 		if (autoCommand != null) 
	            autoCommand.cancel(); 
		 	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		if (autoCommand != null) {
			autoCommand.cancel();
		}
	}


	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	
	@Override
	public void testPeriodic() {
	Scheduler.getInstance().run();
	}
}
