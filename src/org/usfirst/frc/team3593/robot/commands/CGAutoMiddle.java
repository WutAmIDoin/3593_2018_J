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
    		addSequential(new DriveForwardCommand(5, 0.85));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//2nd Cube
    		//Back up a bit
    		addSequential(new DriveForwardCommand(-20, 0.85));
    		
    		//Turn at a 45 to diagonal
    		addSequential(new TurnToDegree(-30, 0.75));
    		
    		//Drive back diagonal
    		addSequential(new DriveForwardCommand(-63, 0.85));
    		
    		//Whip around for intake
    		addSequential(new TurnToDegree(-115, 0.75));
    		
    		//Drive into cube with intake and flap
    		addSequential(new DriveForwardCommand(-20, 0.65));
    		addParallel(new SetFlap(false));
    		addParallel(new SetIntake(0.9));
    		
    		//Flutter Intake for smooth intake
    		addSequential(new SetIntake(0));
    		addSequential(new DelayCommand(0.2));
    		addSequential(new SetIntake(0.9));
    		
    		//Forward a bit
    		addSequential(new DriveForwardCommand(20, 0.85));
    		
    		//Whip around toward Switch
    		addSequential(new TurnToDegree(115, 0.75));
    		
    		//Drive Diagonally to Switch
    		addSequential(new DriveForwardCommand(63, 0.85));
    		
    		//Turn to Switch 
    		addSequential(new TurnToDegree(30, 0.75));
    		addParallel(new SetFlap(true));
    		addParallel(new SetIntake(0));
    		
    		//Drive to edge of Switch
    		addSequential(new DriveForwardCommand(15, 0.9));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//3rd Cube???
    		//Back up a slight bit
    		addSequential(new DriveForwardCommand(-5, 0.85));
    		
    		//Turn to Cube 
    		addSequential(new TurnToDegree(-90, 0.75));
    		
    		//Drive to cube with flap
    		addSequential(new DriveForwardCommand(-58, 0.85));
    		addParallel(new SetFlap(false));
    		addParallel(new SetIntake(0.9));
    		
    		//Flutter Intake for smooth intake
    		addSequential(new SetIntake(0));
    		addSequential(new DelayCommand(0.2));
    		addSequential(new SetIntake(0.9));
    		
    		//Go back to switch
    		addSequential(new DriveForwardCommand(58, 0.85));
    		
    		//Turn to Switch
    		addSequential(new TurnToDegree(90, 0.75));
    		addParallel(new SetIntake(0));
    		addParallel(new SetFlap(true));
    		
    		//Drive back to switch
    		addSequential(new DriveForwardCommand(5, 0.85));
    		
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
    		addSequential(new TurnToDegree(48, 0.75));
    		
    		//Drive Diagonally to switch
    		addSequential(new DriveForwardCommand(75.5, .8));
    		
    		//Turn to toward the switch
    		addSequential(new TurnToDegree(-45, .75));
    		
    		//Drive to switch
    		addSequential(new DriveForwardCommand(8, 0.85));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//2nd Cube
    		//Back up a bit
    		addSequential(new DriveForwardCommand(-20, 0.85));
    		
    		//Turn at a 45 to diagonal
    		addSequential(new TurnToDegree(30, 0.75));
    		
    		//Drive back diagonal
    		addSequential(new DriveForwardCommand(-63, 0.85));
    		
    		//Whip around for intake
    		addSequential(new TurnToDegree(115, 0.75));
    		
    		//Drive into cube with intake and flap
    		addSequential(new DriveForwardCommand(-20, 0.65));
    		addParallel(new SetFlap(false));
    		addParallel(new SetIntake(0.9));
    		
    		//Flutter Intake for smooth intake
    		addSequential(new SetIntake(0));
    		addSequential(new DelayCommand(0.2));
    		addSequential(new SetIntake(0.9));
    		
    		//Forward a bit
    		addSequential(new DriveForwardCommand(20, 0.85));
    		
    		//Whip around toward Switch
    		addSequential(new TurnToDegree(-115, 0.75));
    		
    		//Drive Diagonally to Switch
    		addSequential(new DriveForwardCommand(63, 0.85));
    		
    		//Turn to Switch 
    		addSequential(new TurnToDegree(-30, 0.75));
    		addParallel(new SetFlap(true));
    		addParallel(new SetIntake(0));
    		
    		//Drive to edge of Switch
    		addSequential(new DriveForwardCommand(15, 0.9));
    		
    		//Shoot
    		//Charge Motors
    		addSequential(new SetShooter(RobotMap.switchSpeed));
    		
    		//Activate Launcher
    		addSequential(new ActivateBoosterCommand());
    		
    		//Turn off shooters
    		addSequential(new SetShooter(0));
    		
    		//3rd Cube???
    		//Back up a slight bit
    		addSequential(new DriveForwardCommand(-5, 0.85));
    		
    		//Turn to Cube 
    		addSequential(new TurnToDegree(90, 0.75));
    		
    		//Drive to cube with flap
    		addSequential(new DriveForwardCommand(-58, 0.85));
    		addParallel(new SetFlap(false));
    		addParallel(new SetIntake(0.9));
    		
    		//Flutter Intake for smooth intake
    		addSequential(new SetIntake(0));
    		addSequential(new DelayCommand(0.2));
    		addSequential(new SetIntake(0.9));
    		
    		//Go back to switch
    		addSequential(new DriveForwardCommand(58, 0.85));
    		
    		//Turn to Switch
    		addSequential(new TurnToDegree(-90, 0.75));
    		addParallel(new SetIntake(0));
    		addParallel(new SetFlap(true));
    		
    		//Drive back to switch
    		addSequential(new DriveForwardCommand(5, 0.85));
    		
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
