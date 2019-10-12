/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveBase;

public class OperatorControl extends Command{
    private DriveBase driveSubsystem;
    private Joystick driverJoystick;
    
    public OperatorControl(){
        requires(Robot.driveBase);
        this.driveSubsystem = Robot.driveBase;
        this.driverJoystick = Robot.m_oi.controller;

    }

    public void execute(){
        driveSubsystem.drive(Math.pow(-driverJoystick.getRawAxis(0), 3), Math.pow(-driverJoystick.getRawAxis(1), 3)); 
    }

    @Override  
    protected boolean isFinished(){
        return false;
    }

}