package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class SetIntake extends CommandBase {

	boolean finished = false;
	double setspeed;
	
    public SetIntake(double set) {
        requires(CommandBase.theIntake);
        setspeed = set;
    }


    protected void initialize() {
    }


    protected void execute() {
    	theIntake.setIntakeSpeed(setspeed);
    	Timer.delay(1);
    	finished =true;
    }


    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
