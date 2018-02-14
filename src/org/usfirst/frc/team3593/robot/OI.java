
package org.usfirst.frc.team3593.robot;


import org.usfirst.frc.team3593.robot.subsystems.*;
import org.usfirst.frc.team3593.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;



public class OI extends ShooterSubsystem{
	
	
	public static double axis1;
	public static double axis5;
	public static Button shifter;
	
	public static Button booster;
	public static Button lifter;
	public static Button lowTrig;
	public static Button highTrig;
	

	
	
	private final XboxController XBC1;
	private final XboxController XBC2; 
	
	public OI() {
		XBC1 = new XboxController(0);
		XBC2 = new XboxController(1);
		
		getButton(XBC1, 1).cancelWhenPressed(new AutoCommand());
		
	}
	
	public JoystickButton getButton(XboxController con, int button) {
	return new JoystickButton(con, button);	
	}
		
}
	
	//double value;
	//value = exampleStick.getRawAxis(1);

	
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// three ways:

	// 1. Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// 2. Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// 3. Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
