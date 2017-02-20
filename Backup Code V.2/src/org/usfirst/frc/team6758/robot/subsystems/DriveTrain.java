package org.usfirst.frc.team6758.robot.subsystems;

import org.usfirst.frc.team6758.robot.RobotMap;
import org.usfirst.frc.team6758.robot.commands.DriveWithJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	//Calls Motors - Might be able to put somewhere else
	public static CANTalon leftfront = new CANTalon(3);
	public static CANTalon rightfront = new CANTalon(2);
	public static CANTalon leftback = new CANTalon(0);
	public static CANTalon rightback = new CANTalon(1);
	
	//Make Joystick - Might be able to put somewhere else
	Joystick stick = new Joystick(0);
	
	//teleoperated driving
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    public void driveWithJoystick(){
    	
    	//Sets up the drive capability
    	RobotDrive robotDrive = new RobotDrive(leftfront, leftback, rightfront, rightback);
    	
    	//Keeps the joystick up to date being called every 5ms
    	while(true){
    		
    		//Winch Controlls
			if(stick.getTrigger()){
				RobotMap.WinchLeft.set(1);
				RobotMap.WinchRight.set(1);
			} else {
				RobotMap.WinchLeft.set(0);
				RobotMap.WinchRight.set(0);
			}
			
			//Drives the robot
			robotDrive.mecanumDrive_Cartesian(speedcontrol(stick.getX()), speedcontrol(stick.getY()), speedcontrol(stick.getZ()),0);
			
			//Inverts motors. Don't know why we need it but we need it.
			robotDrive.setInvertedMotor(MotorType.kFrontLeft , true);		
			robotDrive.setInvertedMotor(MotorType.kRearLeft, true); 
			
			// wait 5ms to avoid hogging CPU cycles
			Timer.delay(0.005);
    	}
    }

	private double speedcontrol(double axisposition)
	//This is what makes our throttle work
	{
		return axisposition*((stick.getThrottle()-1)/2);
	}

    //autonomous driving
    public void driveForward(double outSpeed){
    	//sets all the motors to the desired speed
    	leftfront.set(outSpeed);
    	rightfront.set(outSpeed);
    	leftback.set(outSpeed);
    	rightback.set(outSpeed);
    }
    
    public void driveBackwards(double outSpeed){
    	//sets all the motors to go backwards with the desired speed
    	leftfront.set(-outSpeed);
    	rightfront.set(-outSpeed);
    	leftback.set(-outSpeed);
    	rightback.set(-outSpeed);
    }
    
    public void strafeLeft(double outSpeed){
    	leftfront.set(-outSpeed);
    	rightfront.set(outSpeed);
    	leftback.set(outSpeed);
    	rightback.set(-outSpeed);
    }
    
    public void strafeRight(double outSpeed){
    	leftfront.set(outSpeed);
    	rightfront.set(-outSpeed);
    	leftback.set(-outSpeed);
    	rightback.set(outSpeed);
    }

    public void turnCounter(double outSpeed){
    	leftfront.set(-outSpeed);
    	rightfront.set(outSpeed);
    	leftback.set(-outSpeed);
    	rightback.set(outSpeed);
    }
    
    public void turnClock(double outSpeed){
    	leftfront.set(outSpeed);
    	rightfront.set(-outSpeed);
    	leftback.set(outSpeed);
    	rightback.set(-outSpeed);
    }
    
    public void stopDrive(){
    	leftfront.set(0);
    	rightfront.set(0);
    	leftback.set(0);
    	rightback.set(0);
    }
}

