package frc.robot.commands.Catapult;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants;
import java.util.logging.Logger;

public class ArmIntakeStop extends Command{

    private static final Logger LOGGER = Logger.getLogger(ArmIntakeIn.class.getName());

    public ArmIntakeStop(){
        requires(Robot.catapult);
    }
   
    @Override
   public void initialize(){
       Robot.catapult.runIntake(0);
       Robot.catapult.runCatapultMotor(0);
       LOGGER.warning("Arm Intake Stop");
   }
   @Override
   protected boolean isFinished(){
       return false;
   }
}