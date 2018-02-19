package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.command.Command;


public class DriveWithJoystickCommand extends CommandBase {
	public DriveWithJoystickCommand() {
		requires(CommandBase.drive);
		}

	protected void iniialize() {		
	}
    
	protected void execute() {
		drive.driveTank(CommandBase.oi._XBC1.getRawAxis(1),
				-CommandBase.oi._XBC1.getRawAxis(5));
		}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		drive.stop();
	}
	
	protected void interrupted() {
	}
	
}
