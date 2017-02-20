package org.usfirst.frc.team6758.robot.autonomous;

import org.usfirst.frc.team6758.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveForward extends CommandGroup {

    public AutoDriveForward() {
    	
        addSequential(new DriveForward(7, 1));
        addSequential(new TurnClock(8,1));
        
    }
}
