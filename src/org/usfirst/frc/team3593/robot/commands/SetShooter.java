package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class SetShooter extends CommandBase {

	boolean finished = false;
	double speed;
	
    public SetShooter(double set) {
    	requires(CommandBase.theShooter);
    	speed = set;
    }


    protected void initialize() {
    }


    protected void execute() {
    	theShooter.SetShooterSpeed(speed);
    	Timer.delay(1);
    	finished = true;
    }


    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }


    protected void interrupted() {
    }
}
