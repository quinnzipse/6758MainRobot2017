package org.usfirst.frc.team6758.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExampleSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public static CANTalon leftfront = new CANTalon(3);
	public static CANTalon rightfront = new CANTalon(2);
	public static CANTalon leftback = new CANTalon(0);
	public static CANTalon rightback = new CANTalon(1);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
