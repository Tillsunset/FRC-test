package org.usfirst.frc.team2950.robot.commands;

import org.usfirst.frc.team2950.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTrainJoy extends Command{
	
	public DriveTrainJoy() {
		requires(Robot.DriveTrainSubSystem);
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		Robot.DriveTrainSubSystem.tankDrive(Robot.oi.getJoystick());
	}
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		Robot.DriveTrainSubSystem.stop();
	}


}
