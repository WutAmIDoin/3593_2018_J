package org.usfirst.frc.team3593.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team3593.robot.commands.*;

public class Robot extends TimedRobot 
{
	Command autoCommand = null;
	Command powerReporting = null;

	@Override
	public void robotInit() 
	{
		// Initializes all subsystems and the OI
		CommandBase.init();
		powerReporting = new PowerReporting();
		powerReporting.start();
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

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
}
