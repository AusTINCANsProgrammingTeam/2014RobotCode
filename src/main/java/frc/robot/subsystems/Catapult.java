/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Catapult.ArmIntakeStop;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import java.util.logging.Logger;

/**
 * Add your docs here.
 */
public class Catapult extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  private static final Logger LOGGER = Logger.getLogger(Catapult.class.getName());

  private Spark catapultMotor;
  private Spark intakeMotor;

  private DoubleSolenoid leftIntakeSolenoid;
  private DoubleSolenoid rightIntakeSolenoid;

  private DoubleSolenoid catapultPiston;

  public Catapult(int intakeMotorId, int catapultMotorId,
    int catapultSolenoidIdOne, int catapultSolenoidIdTwo,
    int leftSolenoidIdOne, int leftSolenoidTwo,
    int rightSolenoidIdOne, int rightSolenoidIdTwo)
    {
      catapultMotor = new Spark(catapultMotorId);
      catapultPiston = new DoubleSolenoid(catapultSolenoidIdOne,
        catapultSolenoidIdTwo);
      
      leftIntakeSolenoid = new DoubleSolenoid(leftSolenoidIdOne,
      leftSolenoidTwo);

      rightIntakeSolenoid = new DoubleSolenoid(rightSolenoidIdOne,
      rightSolenoidIdTwo);
      
      intakeMotor = new Spark(intakeMotorId);

      catapultPiston.set(Value.kForward);
      rightIntakeSolenoid.set(Value.kForward);      
      leftIntakeSolenoid.set(Value.kForward);
      
    }

    public void toggleWinchPiston()
    {
      if (catapultPiston.get() == Value.kForward)
      {
        catapultPiston.set(Value.kReverse);
      }
      else{
        catapultPiston.set(Value.kForward);
      }
      LOGGER.warning("Toggle Winch");
    }

    public void toggleIntakeArm()
    {
      if (leftIntakeSolenoid.get() == Value.kForward)
      {
        leftIntakeSolenoid.set(Value.kReverse);
        rightIntakeSolenoid.set(Value.kReverse);
      }
      else{
        leftIntakeSolenoid.set(Value.kForward);
        rightIntakeSolenoid.set(Value.kForward);
      }
      LOGGER.warning("Toggle IntakeArm");
    }

    public void runIntake(double speed)
    {
      intakeMotor.set(speed);
    }

    public void runCatapultMotor(double speed)
    {
      catapultMotor.set(speed);
    }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ArmIntakeStop());
  }
}
