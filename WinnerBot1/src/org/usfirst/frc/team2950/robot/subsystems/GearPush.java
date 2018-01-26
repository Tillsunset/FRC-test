package org.usfirst.frc.team2950.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class GearPush extends Subsystem {

	//DoubleSolenoid piston1;

	public GearPush() {
		// Configure Devices
		//piston1 = new DoubleSolenoid(3,2);

		// Put everything to the LiveWindow for testing.
		//LiveWindow.addActuator("Shooter", "Latch Piston", latchPiston);
		//LiveWindow.addActuator("GearPush", "Piston In", piston1);
	}
	
	/** 
	 * Extend solenoid to push gear.
	 */
	/*public void retract1() {
		piston1.set(DoubleSolenoid.Value.kReverse);
		
		
	}
	*/
	
	/**
	 * Retract solenoid to prepare to return to original position to prepare
	 * for the next gear.
	 */
	/*public void extend1() {
		piston1.set(DoubleSolenoid.Value.kForward);
		
	}
	*/
	
	/**
	 * Turns off the piston1 double solenoid. This won't actuate anything
	 * because double solenoids preserve their state when turned off. This
	 * should be called in order to reduce the amount of time that the coils are
	 * powered.
	 */
	/*public void off1() {
		piston1.set(DoubleSolenoid.Value.kOff);
	}
	*/
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	/**
	 * No Default Command
	 */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

