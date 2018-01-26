package org.usfirst.frc.team2950.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2950.robot.commands.ExampleCommand;
import org.usfirst.frc.team2950.robot.commands.Push;
import org.usfirst.frc.team2950.robot.commands.PushBack;
import org.usfirst.frc.team2950.robot.commands.Up;
import org.usfirst.frc.team2950.robot.commands.UpStop;
import org.usfirst.frc.team2950.robot.commands.UpReverse;
import org.usfirst.frc.team2950.robot.commands.CompressorOn;
import org.usfirst.frc.team2950.robot.commands.CompressorOff;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public Joystick joystick;
	public Joystick manipulator;
	
	public JoystickButton joystickButton1;
    public JoystickButton joystickButton2;
    public JoystickButton joystickButton3;
    public JoystickButton joystickButton4;
    public JoystickButton joystickButton5;
    public JoystickButton joystickButton6;
    public JoystickButton joystickButton7;


    public OI(){ 
		joystick = new Joystick(0);
		manipulator = new Joystick(1);
	
		//Set buttons for the GearPush.
		 //joystickButton1 = new JoystickButton(manipulator, 1);
	     //joystickButton1.whenPressed(new Push());
	     //joystickButton2 = new JoystickButton(manipulator, 2);
	     //joystickButton2.whenPressed(new PushBack());
	     
	     //Set buttons for lift.
	     joystickButton3 = new JoystickButton(joystick, 6);
	     joystickButton3.whenPressed(new Up());
	     joystickButton4 = new JoystickButton(joystick, 6);
	     joystickButton4.whenReleased(new UpStop());
	     joystickButton6 = new JoystickButton(joystick, 5);
	     joystickButton6.whenPressed(new UpReverse());
	     joystickButton7 = new JoystickButton(joystick, 5);
	     joystickButton7.whenReleased(new UpStop());

	     
	     //Set buttons for the compressor.
	     //joystickButton5 = new JoystickButton(manipulator, 3);
	     //joystickButton5.whenPressed(new CompressorOn());
	     //joystickButton5 = new JoystickButton(manipulator, 4);
	     //joystickButton5.whenPressed(new CompressorOff());

	     
    }

    
/////////////////////////////////////////////Controllers///////////////////////////////////////////////////////
public Joystick getJoystick() {
return joystick;
}	

public Joystick getManipulator() {
		return manipulator;
	}	
    
}
