package frc.robot.commands.Catapult;

import java.util.logging.Logger;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants;
import java.util.logging.Logger;

public class ArmIntakeOut extends Command{

  private static final Logger LOGGER = Logger.getLogger(ArmIntakeIn.class.getName());

    public ArmIntakeOut(){
      requires(Robot.catapult);
    }

    @Override
    public void initialize(){
        Robot.catapult.runIntake(Constants.kIntakeOut);
        LOGGER.warning("Arm Intake Out");
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}