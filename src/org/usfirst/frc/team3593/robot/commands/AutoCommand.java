package org.usfirst.frc.team3593.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


public class AutoCommand extends CommandBase {

	private boolean finished = false;
	
    public AutoCommand() {
        requires(CommandBase.theDrive);
        
    }


    protected void initialize() {
    }

    
    protected void execute() {
    	theDrive.driveTank(0.5, 0.5);
    	Timer.delay(5);
    	theDrive.driveTank(0, 0);
    	
    	finished = true;
    }


    protected boolean isFinished() {
        return finished;
    }


    protected void end() {
    	theDrive.driveTank(0, 0);
    }

    
    protected void interrupted() {
    }
}
