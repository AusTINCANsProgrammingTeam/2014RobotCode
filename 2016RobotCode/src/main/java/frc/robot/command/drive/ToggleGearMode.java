package frc.robot.command.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleGearMode extends Command{

    @Override
    protected void initialize(){
        Robot.getDriveSubsystem().toggleGearMode();
    }

    @Override
    protected boolean isFinished(){return true;}

}