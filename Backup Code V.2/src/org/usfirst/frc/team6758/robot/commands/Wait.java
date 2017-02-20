package org.usfirst.frc.team6758.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6758.robot.Robot;

public class Wait extends Command {
	
	private double time;
	
	public Wait(double intime) {
		//This calls upon driveTrain
		requires(Robot.driveTrain);
		
		//Assigns the given perameters to a varable.
		time = intime;
		
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.stopDrive();
		setTimeout(time);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.stopDrive();
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.driveTrain.stopDrive();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
