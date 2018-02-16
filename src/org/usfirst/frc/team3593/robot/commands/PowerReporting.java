package org.usfirst.frc.team3593.robot.commands;

public class PowerReporting extends CommandBase {

    public PowerReporting() {
        requires(CommandBase.power);
    }

    protected void initialize() {
    }

    protected void execute() {
    	power.reportPower();
    }

    // This command will be continuously run, so we never want to stop
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
