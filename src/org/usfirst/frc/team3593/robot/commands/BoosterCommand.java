package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class BoosterCommand extends CommandBase {

	Boolean finish = false;
	
    public BoosterCommand() {
        requires(theBooster);
    }

    protected void initialize() {
    }

    protected void execute() {
    	theBooster.setSolenoid(true);
    	Timer.delay(1);
    	theBooster.setSolenoid(false);
    	finish = true;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	theBooster.setSolenoid(false);
    }

    protected void interrupted() {
    	theBooster.setSolenoid(false);
    }
}
