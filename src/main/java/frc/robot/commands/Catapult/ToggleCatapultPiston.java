package frc.robot.commands.Catapult;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleCatapultPiston extends Command{
    
    public ToggleCatapultPiston(){
        //requires(Robot.catapult);

    }

    @Override
    public void initialize(){
        Robot.catapult.toggleWinchPiston();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}