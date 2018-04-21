package org.usfirst.frc.team3593.robot.commands;

import org.usfirst.frc.team3593.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAutoMiddle extends CommandGroup {

    public CGAutoMiddle(String FMSInfo) {
    	//Get everything in position
    	addSequential(new SetShifter(false));
    	addSequential(new SetLifter(true));
    	addSequential(new SetFlap(true));
    	addSequential(new BumpBackCommand());
    	
    	//Drive forward to about halfway down the field
    	addSequential(new DriveForwardCommand(25, 0.8));
    	addParallel(new SetFolders(true));
    	
    	//Determine switch side
    	if (FMSInfo.charAt(0) == 'L') {
    		//Turn to left for diagonal drive
    		addSequential(new TurnToDegree(-35, 0.75));
    		
    		//Drive Diagonally to switch
    		addSequential(new DriveForwardCommand(75.5, 0.8));
    		
    		//Turn to toward the switch
    		addSequential(new TurnToDegree(45, 0.75));
    		
    		//Drive to switch
    		addSequential(new DriveForwardCommand(2, 0.65));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//2nd Cube
    		//Back up a bit
    		addSequential(new DriveForwardCommand(-45, 0.85));
    		
    		//Turn at a 45 to diagonal
    		addSequential(new TurnToDegree(-135, 0.75));
    		addSequential(new SetFlap(false));
    		addParallel(new SetIntake(0.9));
    		//Drive back diagonal
//    		addSequential(new DriveForwardCommand(-30, 0.85));
    		
//    		//Whip around for intake
//    		addSequential(new TurnToDegree(-115, 0.75));
    		
    		//Drive into cube with intake and flap
    		addSequential(new DriveForwardCommand(-52, 0.75));
    		
    		
    		//Flutter Intake for smooth intake
    		addSequential(new DelayCommand(1));
    		//Forward a bit
    		addSequential(new DriveForwardCommand(27, 0.9));
    		
    		addSequential(new SetIntake(0));
    		addSequential(new DelayCommand(0.5));
    		addSequential(new SetIntake(0.9));
    		//Whip around toward Switch
    		addSequential(new TurnToDegree(130, 0.75));
    		
    		//Drive Diagonally to Switch
    		addSequential(new DriveForwardCommand(40, 0.9));
    		addParallel(new SetFlap(true));
    		addParallel(new SetIntake(0));
//    		//Turn to Switch 
//    		addSequential(new TurnToDegree(30, 0.75));

//    		
//    		//Drive to edge of Switch
//    		addSequential(new DriveForwardCommand(15, 0.9));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    	}
    	else if (FMSInfo.charAt(0) == 'R'){
    		//Turn to right for diagonal drive
    		addSequential(new TurnToDegree(50, 0.75));
    		
    		//Drive Diagonally to switch
    		addSequential(new DriveForwardCommand(58, 0.8));
    		addSequential(new DriveForwardCommand(10, 0.7));
    		
    		//Turn to toward the switch
    		addSequential(new TurnToDegree(-50, .75));
    		
    		//Drive to switch
    		addSequential(new DriveForwardCommand(4, 0.65));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//2nd Cube
    		//Back up a bit
    		addSequential(new DriveForwardCommand(-45, 0.85));
    		
    		//Turn at a 45 to diagonal
    		addSequential(new TurnToDegree(135, 0.75));
    		addSequential(new SetFlap(false));
    		addParallel(new SetIntake(0.9));
    		//Drive back diagonal
//    		addSequential(new DriveForwardCommand(-30, 0.85));
    		
//    		//Whip around for intake
//    		addSequential(new TurnToDegree(-115, 0.75));
    		
    		//Drive into cube with intake and flap
    		addSequential(new DriveForwardCommand(-52, 0.75));
    		
    		
    		//Flutter Intake for smooth intake
    		addSequential(new DelayCommand(1));
    		//Forward a bit
    		addSequential(new DriveForwardCommand(27, 0.9));
    		
    		addSequential(new SetIntake(0));
    		addSequential(new DelayCommand(0.5));
    		addSequential(new SetIntake(0.9));
    		//Whip around toward Switch
    		addSequential(new TurnToDegree(-130, 0.75));
    		
    		//Drive Diagonally to Switch
    		addSequential(new DriveForwardCommand(40, 0.9));
    		addParallel(new SetFlap(true));
    		addParallel(new SetIntake(0));
//    		//Turn to Switch 
//    		addSequential(new TurnToDegree(30, 0.75));

//    		
//    		//Drive to edge of Switch
//    		addSequential(new DriveForwardCommand(15, 0.9));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    	}
    }
}
