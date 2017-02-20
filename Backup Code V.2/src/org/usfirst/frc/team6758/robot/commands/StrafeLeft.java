package org.usfirst.frc.team6758.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6758.robot.Robot;

public class StrafeLeft extends Command {
	
	private double time;
	private double speed;
	
	public StrafeLeft(double intime, double inspeed) {
		//This calls upon driveTrain
		requires(Robot.driveTrain);
		
		//Assigns the given perameters to a varable.
		speed = inspeed;
		time = intime;
		
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.strafeLeft(speed);
		setTimeout(time);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.strafeLeft(speed);
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
