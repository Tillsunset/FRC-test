package org.usfirst.frc.team2950.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;

public class IntakeSub {
	public SpeedController leftIntakeCIM;
	public SpeedController rightIntakeCIM;

	public IntakeSub() {
		// TODO Auto-generated constructor stub
		leftIntakeCIM = new CANTalon();
		rightIntakeCIM = new CANTalon();
	}	
	
}
