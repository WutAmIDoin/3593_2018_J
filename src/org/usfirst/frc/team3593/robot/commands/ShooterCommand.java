package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

public class ShooterCommand extends CommandBase {
	

    public ShooterCommand() {
    	requires(CommandBase.theShooter);
    }


    protected void initialize() {
    }


    protected void execute(boolean trigLeft, boolean trigRight) {
    	trigLeft = oi.XBC2.getRawAxis(2) > 0.15;
    	trigRight = oi.XBC2.getRawAxis(3) > 0.15;
    	if(trigLeft) {
    		CommandBase.theShooter.SetShooterSpeed(RobotMap.lowTrig);
    	}else if(trigRight) {
    		CommandBase.theShooter.SetShooterSpeed(RobotMap.highTrig);
    		//CommandBase.UpdateUpperLEDs("runningShooter"); 
    	}else {
    		CommandBase.theShooter.SetShooterSpeed(0);
    	}
    }


    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }


    protected void interrupted() {
    }
}
