package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import java.util.logging.Logger;

public class ChangeGear extends Command{
  private static final Logger LOGGER = Logger.getLogger(ChangeGear.class.getName());



    @Override
    protected void initialize(){
        Robot.driveBase.toggleShift();
        LOGGER.warning("Toggle Shift");
    }

    @Override
    protected boolean isFinished(){return true;}

}