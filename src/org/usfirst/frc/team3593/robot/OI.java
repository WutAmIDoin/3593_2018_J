
package org.usfirst.frc.team3593.robot;


import org.usfirst.frc.team3593.robot.subsystems.*;
import org.usfirst.frc.team3593.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;



public class OI extends ShooterSubsystem{
		
	public final XboxController XBC1;
	public final XboxController XBC2; 
	
	public OI() {
		XBC1 = new XboxController(0);
		XBC2 = new XboxController(1);
	}
	
	public JoystickButton getButton(XboxController con, int button) {
	return new JoystickButton(con, button);	
	}
		
}
