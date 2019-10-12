package frc.robot.commands.Catapult;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleArm extends Command{

    public ToggleArm(){
        requires(Robot.catapult);
    }

    @Override
    public void initialize(){
        Robot.catapult.toggleIntakeArm();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}