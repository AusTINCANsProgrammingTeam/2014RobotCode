package frc.robot.command.catapult;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ChargeCat extends Command{


    public ChargeCat(){
        requires(Robot.getCatSubsystem());
    }

    public void initialize(){
        Robot.getCatSubsystem().loadCat();
    }

    public boolean isFinished(){
        return true;
    }
}