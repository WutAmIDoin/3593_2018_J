package org.usfirst.frc.team3593.robot.subsystems;

import java.util.Hashtable;

import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.CommandBase;
import org.usfirst.frc.team3593.robot.commands.PowerReporting;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;


public class PowerSubsystem extends Subsystem {
	
	PowerDistributionPanel pdp;
	
	public PowerSubsystem()
	{
		pdp = new PowerDistributionPanel(0);
		
	}
	
	public void reportPower() {
		
		// Add power values to the table here
		CommandBase.dashTable.put("battVoltage", pdp.getVoltage());
		// Get total current of the PDP
		CommandBase.dashTable.put("totalCurrent", pdp.getTotalCurrent());
		
		CommandBase.dashTable.put("driveRight1", pdp.getCurrent(RobotMap.pdp_driveRight1));
		CommandBase.dashTable.put("driveRight2", pdp.getCurrent(RobotMap.pdp_driveRight2));
		CommandBase.dashTable.put("driveLeft1", pdp.getCurrent(RobotMap.pdp_driveLeft1));
		CommandBase.dashTable.put("driveLeft2", pdp.getCurrent(RobotMap.pdp_driveLeft2));
		CommandBase.dashTable.put("shooterRight1", pdp.getCurrent(RobotMap.pdp_shooterRight1));
		CommandBase.dashTable.put("shooterRight2", pdp.getCurrent(RobotMap.pdp_shooterRight2));
		CommandBase.dashTable.put("shooterLeft1", pdp.getCurrent(RobotMap.pdp_shooterLeft1));
		CommandBase.dashTable.put("shooterLeft2", pdp.getCurrent(RobotMap.pdp_shooterLeft2));
		CommandBase.dashTable.put("IntakeLeft", pdp.getCurrent(RobotMap.pdp_IntakeLeft));
		CommandBase.dashTable.put("IntakeRight", pdp.getCurrent(RobotMap.pdp_IntakeRight));
		CommandBase.dashTable.put("cimmy1", pdp.getCurrent(RobotMap.pdp_cimmy1));
		CommandBase.dashTable.put("cimmy2", pdp.getCurrent(RobotMap.pdp_cimmy2));
	}

    public void initDefaultCommand() {
        setDefaultCommand(new PowerReporting());
    }

}

