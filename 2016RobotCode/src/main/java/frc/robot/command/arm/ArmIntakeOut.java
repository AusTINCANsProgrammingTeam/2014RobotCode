package frc.robot.command.arm;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.arm.ArmSubsystem.IntakeDirection;

public class ArmIntakeOut extends Command{
    private static final Logger LOGGER = Logger.getLogger(ArmIntakeOut.class.getName());

    public ArmIntakeOut(){
        requires(Robot.getArmSubsystem());
    }

    @Override
    public void initialize(){
        Robot.getArmSubsystem().runInake(IntakeDirection.OUT);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
