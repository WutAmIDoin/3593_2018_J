package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;


public class LaunchCube extends CommandBase {
	boolean finished = false;

    public LaunchCube() {
        requires(CommandBase.theShooter);
    }


    protected void initialize() {
    }


    protected void execute() {
    	theBooster.setSolenoid(true);
    	Timer.delay(2);
    	theBooster.setSolenoid(false);
    	finished = true;
    }

 
    protected boolean isFinished() {
        return finished;
    }


    protected void end() {
    	theBooster.setSolenoid(false);
    }


    protected void interrupted() {
    	theBooster.setSolenoid(false);
    }
}