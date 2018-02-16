package org.usfirst.frc.team3593.robot.subsystems;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FolderSubsystem extends Subsystem {
Solenoid folder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

public FolderSubsystem(){
	folder = new Solenoid(RobotMap.flapSolenoidChannel);
}
  
public void setFolder(boolean setFolders){
	
	folder.set(setFolders);
	
}
public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

