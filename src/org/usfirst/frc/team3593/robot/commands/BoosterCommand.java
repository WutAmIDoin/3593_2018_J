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
    	CommandBase.theBooster.BoosterCommand(true);
    	Timer.delay(1);
    	finish = true;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	CommandBase.theBooster.BoosterCommand(false);
    }

    protected void interrupted() {
    }
}
