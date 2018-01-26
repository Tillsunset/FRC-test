package org.usfirst.frc.team2950.robot.commands;

import org.usfirst.frc.team2950.robot.Robot;
import org.usfirst.frc.team2950.robot.subsystems.IntakeSub;

import edu.wpi.first.wpilibj.command.Command;


public class IntakeCom {

	public IntakeCom() {
		// TODO Auto-generated constructor stub
		requires(Robot.intakeSub);
	}
	
	protected void execute() {
		Robot.intakeSub.leftIntakeCIM.set(1);
		Robot.intakeSub.rightIntakeCIM.set(-1);
	}

}
