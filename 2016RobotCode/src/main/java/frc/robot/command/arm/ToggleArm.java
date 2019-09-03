package frc.robot.command.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleArm extends Command{

    public ToggleArm(){
        requires(Robot.getArmSubsystem());
    }

    @Override
    public void initialize(){
        Robot.getArmSubsystem().toggleArm();
    }

    @Override
    public boolean isFinished(){
        return true;
    }


}