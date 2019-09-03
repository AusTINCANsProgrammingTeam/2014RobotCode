/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import javax.management.RuntimeErrorException;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.*;
import frc.robot.OperatorInterface.ButtonMode;
import frc.robot.command.arm.ArmIntakeIn;
import frc.robot.command.arm.ArmIntakeOut;
import frc.robot.command.arm.ToggleArm;
import frc.robot.command.catapult.ToggleCatPiston;
import frc.robot.command.drive.OperatorControl;
import frc.robot.command.drive.ToggleGearMode;
import frc.robot.subsystems.arm.ArmSubsystem;
import frc.robot.subsystems.catapult.CatapultSubsystem;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.drive.DriveSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private static OperatorInterface operatorInterface;
  private static DriveSubsystem driveSubstsem;
  private static ArmSubsystem armSubsystem;
  private static CatapultSubsystem catapultSubsystem;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    operatorInterface = new OperatorInterface();
    driveSubstsem = new DriveSubsystem(
           new SparkGroup(
                    new Spark(RobotMap.LEFT_MOTOR_1),
                    new Spark(RobotMap.LEFT_MOTOR_2),
                    new Spark(RobotMap.LEFT_MOTOR_3)
                  
            ),
            new SparkGroup(
                  new Spark(RobotMap.RIGHT_MOTOR_1),
                  new Spark(RobotMap.RIGHT_MOTOR_2),
                  new Spark(RobotMap.RIGHT_MOTOR_3)
            ),

            new DoubleSolenoid(RobotMap.GEARBOX_FOWARD_CHANNEL, RobotMap.GEARBOX_REVERSE_CHANNEL)
    );

    armSubsystem = new ArmSubsystem(
                  new DoubleSolenoid(RobotMap.PCM_ADRESS, RobotMap.LEFT_PISTION_FOWARD, RobotMap.LEFT_PISTON_REVERSE),

                  new DoubleSolenoid(RobotMap.PCM_ADRESS, RobotMap.RIGHT_PISTON_FOWARD, RobotMap.RIGHT_PISTION_REVERSE),

                  new Spark(RobotMap.ARM_INTAKE_MOTOR)
    );

    catapultSubsystem = new CatapultSubsystem(
                    new Spark(RobotMap.CAT_MOTOR),

                    new DoubleSolenoid(RobotMap.PCM_ADRESS, RobotMap.CAT_FOWARD, RobotMap.CAT_REVERSE));
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
//
  }

  public static DriveSubsystem getDriveSubsystem(){
    if(driveSubstsem != null){
        return driveSubstsem;
    }
    throw new RuntimeException("Drive subsystem has not yet been initialized");
  }

  public static ArmSubsystem getArmSubsystem(){
      if(armSubsystem != null){
        return armSubsystem;
      }
      throw new RuntimeException("Arm Subsystem was not initialized");

  }

  public static CatapultSubsystem getCatSubsystem(){
        if(catapultSubsystem != null){
          return catapultSubsystem;
        }
        throw new RuntimeException("Catapult subsystem was not initialized");
  }

  public static OperatorInterface getOperatorInterface(){
    return operatorInterface;
  }

  /**
   * This function is called periodically during operator control.
   */
 
   @Override
   public void teleopInit(){
     operatorInterface.bindButton("buttonA", ButtonMode.TOGGLE_WHEN_PRESSED, new ToggleGearMode(), 0);
     operatorInterface.bindButton("buttonY", ButtonMode.TOGGLE_WHEN_PRESSED, new ToggleCatPiston(), 0);
     operatorInterface.bindButton("buttonB", ButtonMode.TOGGLE_WHEN_PRESSED, new ToggleArm(), 0);
     operatorInterface.bindButton("buttonRB", ButtonMode.WHEN_PRESSED, new ArmIntakeIn(), 0);
     operatorInterface.bindButton("buttonRT", ButtonMode.WHEN_PRESSED, new ArmIntakeOut(), 0);

     Scheduler.getInstance().add(new OperatorControl());


    

   }
 
 
   @Override
  public void teleopPeriodic() {
  
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
