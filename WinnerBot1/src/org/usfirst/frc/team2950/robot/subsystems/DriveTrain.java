package org.usfirst.frc.team2950.robot.subsystems;


import org.usfirst.frc.team2950.robot.commands.DriveWithJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANSpeedController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

/**
 *  The DriveTrain subsystem controls the robot's chassis and reads in
 * information about it's speed and position.
 */
public class DriveTrain extends Subsystem {

	// Subsystem devices
	private SpeedController frontLeftCIM;
	private SpeedController frontRightCIM;
	private SpeedController backLeftCIM;
	private SpeedController backRightCIM;
	private RobotDrive drive;
	public DriveTrain() {
		// Configure drive motors
		frontLeftCIM = new CANTalon(1);
		frontRightCIM = new CANTalon(3);
		backLeftCIM = new CANTalon(2);
		backRightCIM = new CANTalon(17);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
		
		// Configure the RobotDrive to reflect the fact that all our motors are
				// wired backwards and our drivers sensitivity preferences.
				drive = new RobotDrive(frontLeftCIM, backLeftCIM, frontRightCIM, backRightCIM);
				drive.setSafetyEnabled(false);
				drive.setExpiration(1);
				drive.setSensitivity(0.5);
				drive.setMaxOutput(0.95);
				drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
				drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
				drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
				drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
				
	}

/**
* When other commands aren't using the drivetrain, allow tank drive with
* the joystick.
*/
    public void initDefaultCommand() {

		setDefaultCommand(new DriveWithJoystick());
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
	 * @param joy PS3 style joystick to use as the input for tank drive.  
	 */
	public void tankDrive(Joystick joy) {
		drive.tankDrive(joy.getY()/0.83, joy.getRawAxis(5)/0.83);
	}

	/**
	 * @param leftAxis Left sides value
	 * @param rightAxis Right sides value
	 */
	public void tankDrive(double leftAxis, double rightAxis) {
		drive.tankDrive(leftAxis, rightAxis);
			
	}
	
	/**
	 * Drive forward.
	 */
	public void DriveFoward() {
		
		drive.tankDrive(-0.6,-0.6);
		
	}
	


    /**
     * Drive backward.
     */
	public void DriveBackwardMiddle() {
	
		drive.tankDrive(0.6,0.6);
	
}
	
	/**
	 * Drive forward in middle for auto.
	 */
	public void DriveFowardMiddleGear() {
		
		drive.tankDrive(-0.55,-0.55);
		
	}
	
	/**
	 * Drive forward in middle for auto.
	 */
	public void DriveFowardLeft() {
		
		drive.tankDrive(-0.69,-0.69);
		
	}
	
	/**
	 * Drive forward in middle for auto.
	 */
	public void DriveFowardLeft2() {
		
		drive.tankDrive(-0.65,-0.65);
		
	}
	
	/**
	 * Drive forward in middle for auto.
	 */
	public void DriveFowardRight() {
		
		drive.tankDrive(-0.69,-0.69);
		
	}
	
	/**
	 * Drive forward in middle for auto.
	 */
	public void DriveFowardRight2() {
		
		drive.tankDrive(-0.65,-0.65);
		
	}
	
	
	/**
	 * Turn right.
	 */
	public void turnRight(){
		
		drive.tankDrive(-0.8,0.8);
	}
	
	
	/**
	 * Turn left.
	 */
	public void turnLeft(){
		
		drive.tankDrive(0.8,-0.8);
	}


	/**
	 * Stop the drivetrain from moving.
	 */
	public void stop() {
		drive.tankDrive(0, 0);
	}
	
	
	/**
	 * @return The encoder getting the distance and speed of left side of the drivetrain.
	 */
	//public Encoder getLeftEncoder() {
		//return leftEncoder;

	/**
	 * @return The encoder getting the distance and speed of right side of the drivetrain.
	 */
	
	/**
	 * @return The current angle of the drivetrain.
	 */
}

