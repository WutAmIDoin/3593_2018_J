package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;


public class DriveCommand extends CommandBase {

    public DriveCommand() {
        requires(theDrive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	CommandBase.theDrive.driveTank(CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1driveleft), CommandBase.oi.XBC1.getRawAxis(RobotMap.XBC1driveright));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
