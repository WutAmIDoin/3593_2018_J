package org.usfirst.frc.team3593.robot.commands;



import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Command;



/**

 *

 */

public class SetShooterSpeed extends CommandBase {

	double speed;

	boolean finished = false;

	

    public SetShooterSpeed(double set) {

        requires(CommandBase.shooter);

        speed = set;

    }



    // Called just before this Command runs the first time

    protected void initialize() {

    }



    // Called repeatedly when this Command is scheduled to run

    protected void execute() {

    	shooter.setSpeed(speed);

    	Timer.delay(1);

    	finished = true;

    }



    // Make this return true when this Command no longer needs to run execute()

    protected boolean isFinished() {

        return finished;

    }



    // Called once after isFinished returns true

    protected void end() {

    }



    // Called when another command which requires one or more of the same

    // subsystems is scheduled to run

    protected void interrupted() {

    }

}
