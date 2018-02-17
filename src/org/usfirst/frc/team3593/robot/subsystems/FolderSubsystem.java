package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FolderSubsystem extends Subsystem {
	
	Solenoid Fold;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public FolderSubsystem() {
		
	Fold = new Solenoid(RobotMap.Fold);
	}
	public void setFolder(boolean Fouble) {
		if(Fold.get() != Fouble) {
			Fold.set(Fouble);
			CommandBase.toggleFolder = Fouble;
		}
		
		
		
		
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

