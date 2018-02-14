
package org.usfirst.frc.team3593.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3593.robot.commands.*;
import org.usfirst.frc.team3593.robot.subsystems.*;


public class Robot extends TimedRobot {
	
	Command AutoCommand = null;
	
	public static final ExampleSubsystem kExampleSubsystem
			= new ExampleSubsystem();
	public static OI m_oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	public static final DriveSubsystem theDriveSubsystem = new DriveSubsystem();
	
	@Override
	public void robotInit() {
		CommandBase.init();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
	@Override
	public void autonomousInit() {
		AutoCommand = new AutoCommand();
		AutoCommand.start();
	}

	
	@Override
	public void autonomousPeriodic() {
		
		Scheduler.getInstance();
	}

	@Override
	public void teleopInit() {
		if (AutoCommand != null) {
			AutoCommand.cancel();
		}
		
	}

	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	
	@Override
	public void testPeriodic() {
		Scheduler.getInstance();
	}
}
