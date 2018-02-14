/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3593.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc.team3593.robot.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private final XboxController XBC1;
	private final XboxController XBC2;
	
	public static double XBC2_axis2;
	public static double XBC2_axis3;
	
	
	public OI() {
		//Controllers
		XBC1 = new XboxController(0);
		XBC2 = new XboxController(1);
		
		
		//XBC1 Controls
		getButton(XBC1, 7).whenPressed(new AutoCommand());
		
		//XBC2 Controls
		getButton(XBC2, 1).whenPressed(new ActivateLauncherCommand());
		
		//Axis Values?
		XBC2_axis2 = XBC2.getRawAxis(2);
		XBC2_axis3 = XBC2.getRawAxis(3);
		
	}
	
	public JoystickButton getButton(XboxController con, int button) {
		return new JoystickButton(con, button);
	}
	
	
	
	
}
