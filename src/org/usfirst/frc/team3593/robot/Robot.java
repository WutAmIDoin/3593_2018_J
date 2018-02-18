package org.usfirst.frc.team3593.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3593.robot.commands.AutoCommand;
import org.usfirst.frc.team3593.robot.commands.CommandBase;
import org.usfirst.frc.team3593.robot.commands.PowerReporting;
import org.usfirst.frc.team3593.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3593.robot.subsystems.ShooterSubsystem;

 public class Robot extends TimedRobot {

	Command autoCommand = null;
	Command powerReporting = null;

	@Override

	public void robotInit() {

		CommandBase.init();

	}

	@Override

	public void disabledInit() {

	}

	@Override

	public void disabledPeriodic() {
	}

	@Override

	public void autonomousInit() {

		autoCommand = new AutoCommand(DriverStation.getInstance().getGameSpecificMessage());

		autoCommand.start();

	}

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

	}

}