package org.usfirst.frc.team2950.robot.subsystems;

import org.usfirst.frc.team2950.robot.Robot;
import org.usfirst.frc.team2950.robot.commands.DriveWithJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController frontLeftCIM;
	private SpeedController frontRightCIM;
	private SpeedController backLeftCIM;
	private SpeedController backRightCIM;
	private RobotDrive drive;
	
	public Drivetrain() {
		// Configure drive motors
		frontLeftCIM = new CANTalon(1);
		frontRightCIM = new CANTalon(3);
		backLeftCIM = new CANTalon(5);
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

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
		setDefaultCommand(new DriveWithJoystick());
    }
    
    public void arcadeDrive(Joystick joy){
    	drive.arcadeDrive(joy.getY()/0.83, joy.getRawAxis(5)/0.83);
    }
    public void stop(){
    	drive.arcadeDrive(0.0, 0.0);
    }
    public void DriveForward(double power, double spin){
    	drive.arcadeDrive( power, spin);
    }
    public void DriveForward1(double power){
    	Robot.drivetrain.DRIVEFORWARD( -power);
    }
    public void Grip(double power){
    	
    }
    
    
    
    
    
}

