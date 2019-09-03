package frc.robot.command.arm;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.arm.ArmSubsystem.IntakeDirection;

public class ArmIntakeIn extends Command{

    public ArmIntakeIn(){
        requires(Robot.getArmSubsystem());

    }
   
    @Override
   public void initialize(){
       Robot.getArmSubsystem().runInake(IntakeDirection.IN);
   }
   @Override
   protected boolean isFinished(){
       return true;
   }
        
        
        
    }
