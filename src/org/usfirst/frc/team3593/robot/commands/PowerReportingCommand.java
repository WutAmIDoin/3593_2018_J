package org.usfirst.frc.team3593.robot.commands;



public class PowerReportingCommand extends CommandBase {



    public PowerReportingCommand() {

        requires(CommandBase.power);

    }
    
    protected void initialize() {

    }

    protected void execute() {

    	power.reportPower();

    }

    protected boolean isFinished() {

        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }

}