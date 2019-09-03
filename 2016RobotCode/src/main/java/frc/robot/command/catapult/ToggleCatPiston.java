package frc.robot.command.catapult;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.drive.DriveSubsystem;

public class ToggleCatPiston extends Command{
    
    public ToggleCatPiston(){
        requires(Robot.getCatSubsystem());

    }

    @Override
    public void initialize(){
        Robot.getCatSubsystem().TogglePiston();
    }

    @Override
    public boolean isFinished(){
        return true;
    }


}