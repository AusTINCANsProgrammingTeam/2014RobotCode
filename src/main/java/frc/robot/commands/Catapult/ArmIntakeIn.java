package frc.robot.commands.Catapult;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants;
import java.util.logging.Logger;

public class ArmIntakeIn extends Command{
    private static final Logger LOGGER = Logger.getLogger(ArmIntakeIn.class.getName());

    public ArmIntakeIn(){
        requires(Robot.catapult);
    }
   
    @Override
   public void initialize(){
      LOGGER.warning("Arm Intake In");
      Robot.catapult.runIntake(Constants.kIntakeIn);
   }
   @Override
   protected boolean isFinished(){
       return true;
   }
}