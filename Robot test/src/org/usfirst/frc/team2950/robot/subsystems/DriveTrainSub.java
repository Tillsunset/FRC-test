package org.usfirst.frc.team2950.robot.subsystems;

import org.usfirst.frc.team2950.robot.commands.DriveTrainJoy;
import org.usfirst.frc.team2950.robot.commands.DriveTrainCom;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrainSub extends Subsystem {
	
	private SpeedController frontleftCIM  = new CANTalon(1);
	private SpeedController frontrightCIM = new CANTalon(3);
	private SpeedController backleftCIM   = new CANTalon(2);
	private SpeedController backrightCIM  = new CANTalon(17);
	
	private RobotDrive drive;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void DriveTrainSubSystem() {
		
		drive = new RobotDrive(frontleftCIM, frontrightCIM, backleftCIM, backrightCIM);
		drive.setSafetyEnabled(false);
		drive.setExpiration(1);
		drive.setSensitivity(0.5);
		drive.setMaxOutput(1);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft,  true);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft,   true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight,  false);
		
	}
	
	public void tankDrive (Joystick joy) {
		drive.tankDrive(joy.getY(), joy.getRawAxis(0)/.83);
	}
	
	public void stop() {
		drive.tankDrive(0,0);
	}



    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTrainJoy());
    }
   
}

