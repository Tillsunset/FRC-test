package org.usfirst.frc.team2950.robot.subsystems;

import com.ctre.CANTalon;

import org.usfirst.frc.team2950.robot.RobotMap;
import org.usfirst.frc.team2950.robot.commands.DriveTrainCom;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class DriveTrainSub extends Subsystem {
	CANTalon LeftDrive, RightDrive;
	RobotDrive drive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void DriveTrainSubSystem() {
		LeftDrive  = new CANTalon(RobotMap.LeftMotor);
		RightDrive = new CANTalon(RobotMap.RightMotor);
		
		drive = new RobotDrive(LeftDrive, RightDrive);
	}
	
	public void tankDrive (double x, double y) {
		drive.tankDrive(x,y);
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTrainCom());
    }
   
}

