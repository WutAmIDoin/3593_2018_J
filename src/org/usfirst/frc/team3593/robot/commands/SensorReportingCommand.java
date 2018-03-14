package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SensorReportingCommand extends Command {

	public SensorReportingCommand() {
    	requires(CommandBase.theSensorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        CommandBase.dashTable.put("systemPressure", CommandBase.theSensorSubsystem.getPressure());
        double[] encDis = CommandBase.theSensorSubsystem.getEncDistance();
        CommandBase.dashTable.put("driveLeftEncoder", encDis[0]);
        CommandBase.dashTable.put("driveRightEncoder", encDis[1]);
        CommandBase.dashTable.put("gyroAngle", CommandBase.theSensorSubsystem.getGyroAngle());
        CommandBase.dashTable.put("flapPosition", CommandBase.toggleFlap ? 1 : 0);
        CommandBase.dashTable.put("driveShifter", CommandBase.toggleShifters ? 1 : 0);
        CommandBase.dashTable.put("shooterPosition", CommandBase.toggleLifter ? 1 : 0);
        CommandBase.dashTable.put("intakeArms", CommandBase.toggleFolders ? 1 : 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
