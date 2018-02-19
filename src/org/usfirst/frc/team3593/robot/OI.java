/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3593.robot;

import org.usfirst.frc.team3593.robot.commands.AutoCommand;
import org.usfirst.frc.team3593.robot.commands.ToggleShifterCommand;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final XboxController _XBC1;
	public final XboxController _XBC2;
	public OI() {
		_XBC1 = new XboxController(0);
		_XBC2= new XboxController(1);

		getButton(_XBC1, 1).cancelWhenPressed(new ToggleShifterCommand());
		
	}
	
	public JoystickButton getButton(XboxController con, int button) {
		return new JoystickButton(con, button);
	}
}
