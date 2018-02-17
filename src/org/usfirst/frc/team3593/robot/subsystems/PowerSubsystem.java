package org.usfirst.frc.team3593.robot.subsystems;

import java.util.Hashtable;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3593.robot.RobotMap;
import org.usfirst.frc.team3593.robot.commands.PowerCommand;


public class PowerSubsystem extends Subsystem {

	PowerDistributionPanel pdp;
    NetworkTable nt_power;
    
    public PowerSubsystem() {
    	pdp = new PowerDistributionPanel(0);
    	nt_power = NetworkTableInstance.getDefault().getTable("power");
    }
    
    public void reportPower() {
    	Hashtable<String, Double> values = getPowerValues();
    	for(String key : values.keySet()) {
    		nt_power.getEntry(key).setDouble(values.get(key));
    	}
    }
    
    public Hashtable<String, Double> getPowerValues(){
    	Hashtable<String, Double> table = new Hashtable<String, Double>();
    	// Add power values to the table here
    	table.put("battVoltage", pdp.getVoltage());
    	// Get total current of the PDP
    	table.put("totalCurrent", pdp.getTotalCurrent());
    	
    	table.put("driveLeft1", pdp.getCurrent(RobotMap.pdp_driveLeft1));
    	table.put("driveLeft2", pdp.getCurrent(RobotMap.pdp_driveLeft2));
    	table.put("driveRight1", pdp.getCurrent(RobotMap.pdp_driveRight1));
    	table.put("driveRight2", pdp.getCurrent(RobotMap.pdp_driveRight2));
		table.put("shooterLeft1", pdp.getCurrent(RobotMap.pdp_shooterLeft1));
		table.put("shooterLeft2", pdp.getCurrent(RobotMap.pdp_shooterLeft2));
		table.put("shooterRight1", pdp.getCurrent(RobotMap.pdp_shooterRight1));
		table.put("shooterRight2", pdp.getCurrent(RobotMap.pdp_shooterRight2));
		table.put("IntakeLeft", pdp.getCurrent(RobotMap.pdp_IntakeLeft));
		table.put("IntakeRight", pdp.getCurrent(RobotMap.pdp_IntakeRight));
		table.put("cimmy1", pdp.getCurrent(RobotMap.pdp_cimmy1));
		table.put("cimmy2", pdp.getCurrent(RobotMap.pdp_cimmy2));
    	
    	return table;
    }

    public void initDefaultCommand() { 
    	setDefaultCommand(new PowerCommand());
    }
}

