package frc.robot.command.drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.drive.DriveSubsystem;

public class OperatorControl extends Command{
    private DriveSubsystem driveSubsystem;
    private Joystick driverJoystick;
    
    public OperatorControl(){
        this.driveSubsystem = Robot.getDriveSubsystem();
        this.driverJoystick = Robot.getOperatorInterface().getDriveController();

    }

    public void execute(){
        driveSubsystem.arcadeDrive(Math.pow(-driverJoystick.getRawAxis(1), 3), Math.pow(-driverJoystick.getRawAxis(2), 3));
        
    }

    @Override  
    protected boolean isFinished(){
        return false;
    }

}