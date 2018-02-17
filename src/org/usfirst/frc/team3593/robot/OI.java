
package org.usfirst.frc.team3593.robot;


import org.usfirst.frc.team3593.robot.subsystems.*;
import org.usfirst.frc.team3593.robot.commands.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;



public class OI extends ShooterSubsystem{
		
	public final XboxController XBC1;
	public final XboxController XBC2; 
	
	public OI() {
		XBC1 = new XboxController(0);
		XBC2 = new XboxController(1);
		
		// XBC1
		getButton(XBC1, 5).whenPressed(new ToggleShifter());
		
		// XBC2
		getButton(XBC2, 1).whenPressed(new BoosterCommand());
		getButton(XBC2, 3).whenPressed(new ToggleLifter());
		getButton(XBC2, 4).whenPressed(new ToggleFlap());
	}
	
	// the toggles you put in here
	// the drive and shooter and booster and all that are defaults you don't need to put in here
	
	public JoystickButton getButton(XboxController con, int button) {
	return new JoystickButton(con, button);	
	}
		
}
