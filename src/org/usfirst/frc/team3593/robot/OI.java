package org.usfirst.frc.team3593.robot;

import org.usfirst.frc.team3593.robot.commands.*;

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
		_XBC2 = new XboxController(1);
		
		getButton(_XBC1, 1).whenPressed(new ToggleShifters());
		if(_XBC1.getPOV() != -1){
			new SwitchCameraView(_XBC1.getPOV());
		}
	}
	
	public JoystickButton getButton(XboxController con, int button) {
		return new JoystickButton(con, button);
	}
}
