package frc.robot.commands.Catapult;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import java.util.logging.Logger;

public class ChargeCatapult extends Command{
  private static final Logger LOGGER = Logger.getLogger(ArmIntakeIn.class.getName());


    public ChargeCatapult(){
        requires(Robot.catapult);
    }

    public void initialize(){
        Robot.catapult.runCatapultMotor(.5);
        LOGGER.warning("Charge Catapult");
    }

    public boolean isFinished(){
        return true;
    }
}