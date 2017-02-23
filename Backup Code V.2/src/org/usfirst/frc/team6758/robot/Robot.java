//This is were everything comes together

package org.usfirst.frc.team6758.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6758.robot.subsystems.*;
import org.usfirst.frc.team6758.robot.RobotMap;
import org.usfirst.frc.team6758.robot.autonomous.*;
import org.usfirst.frc.team6758.robot.commands.*;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class Robot extends IterativeRobot {
		//anything stored here, is available throughout this class.
	
	//Start up subsystems
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain driveTrain = new DriveTrain();
	
	//These are placeholders
	RobotDrive robotDrive;
	CameraServer camera;
	Command autonomousCommand;
	
	SendableChooser<Command> chooser = new SendableChooser<>(); //This had something to do with autonomous
	
	@Override
	public void robotInit() {
		//starts cameras
    	camera = CameraServer.getInstance();
    	camera.startAutomaticCapture(0);
    	camera.startAutomaticCapture(1);
    	
    	//Turns off stupid error message
		robotDrive.setSafetyEnabled(false);
		
		//List of autonomous commands to pick from
		chooser.addDefault("Do Nothing", new Wait(15));
		chooser.addObject("Drive Forward", new AutoDriveForward());
		
		//Asks what autonomous command you would like to run
		SmartDashboard.putData("Autonomous", chooser);
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		//If there is an autonomous command this will start it
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		}
	
	public Robot() {
		
    	//turn on robot drive
		robotDrive = new RobotDrive( RobotMap.leftfront, RobotMap.leftback, RobotMap.rightfront , RobotMap.rightback );
		
		robotDrive.setExpiration(0.1);
		}
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run(); 
	}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
