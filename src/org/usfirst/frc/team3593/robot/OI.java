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

	public final XboxController XBC1;
	public final XboxController XBC2;
	
	public OI() {
		//Controllers
		XBC1 = new XboxController(0);
		XBC2 = new XboxController(1);
		
		//Commands XBC1
		getButton(XBC1, 6).whenPressed(new ToggleShifterCommand());
		getButton(XBC1, 5).whenPressed(new ToggleFolderCommand());
		//getButton(XBC1, 0).whenPressed(new SwitchDriveCommand());
		
		//Commands XBC2
		getButton(XBC2, 1).whenPressed(new ActivateBoosterCommand());
		getButton(XBC2, 3).whenPressed(new ToggeLifterCommand());
		getButton(XBC2, 4).whenPressed(new ToggleFlapCommand());
		
		if(XBC1.getPOV() != -1) {
			new SwitchCameraViewCommand(XBC1.getPOV());
		}
	}
	
	public JoystickButton getButton(XboxController con, int button) {
		return new JoystickButton(con, button);
	}
	
	
	
	
}
