package org.usfirst.frc.team6758.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6758.robot.Robot;

public class DriveForward extends Command {
	
	private double time;
	private double speed;
	
	public DriveForward(double intime, double inspeed) {
		//This calls upon driveTrain
		requires(Robot.driveTrain);
		
		//Assigns the given perameters to a varable.
		speed = inspeed;
		time = intime;
		
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.driveForward(speed);
		setTimeout(time);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.driveForward(speed);
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
