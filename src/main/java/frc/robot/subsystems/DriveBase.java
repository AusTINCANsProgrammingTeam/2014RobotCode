/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.Constants;
import frc.robot.commands.Drive.OperatorControl;


/**
 * Add your docs here.
 */
public class DriveBase extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private DifferentialDrive differentialDrive;
  private DoubleSolenoid gearDoubleSolenoid;

  private TalonSRX leftMasterTalon, rightMasterTalon,
   leftSlaveOneTalon, leftSlaveTwoTalon, rightSlaveOneTalon, rightSlaveTwoTalon;

  private Spark leftSparkOne, leftSparkTwo, leftSparkThree, rightSparkOne, rightSparkTwo, rightSparkThree;

  //private SparkMax leftMasterSpark, leftSlaveOneSpark, leftSlaveTwoSpark, rightMasterSpark, rightSlaveOneSpark, rightSlaveTwoSpark;

  private SpeedControllerType speedControllerType;

  public enum SpeedControllerType
  {
    TALONSRX,
    SPARKMAX,
    SPARK
  };

  private void CreateTalonSRXDriveBase(int leftMasterId, int leftSlaveIdOne, int leftSlaveIdTwo,
  int rightMasterId, int rightSlaveIdOne, int rightSlaveIdTwo)
  {
    leftMasterTalon = new TalonSRX(leftMasterId);
    //leftMasterTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,				// Local Feedback Source
    //Constants.PID_PRIMARY,					// PID Slot for Source [0, 1]
    //Constants.kTimeOutMs);	


    leftSlaveOneTalon = new TalonSRX(leftSlaveIdOne);    
    leftSlaveTwoTalon = new TalonSRX(leftSlaveIdTwo);
    rightMasterTalon = new TalonSRX(rightMasterId);
    rightSlaveOneTalon = new TalonSRX(rightSlaveIdOne);
    rightSlaveTwoTalon = new TalonSRX(rightSlaveIdTwo);

    rightMasterTalon.configFactoryDefault();
    rightSlaveOneTalon.configFactoryDefault();
    rightSlaveTwoTalon.configFactoryDefault();
    rightSlaveOneTalon.follow(rightMasterTalon);
    rightSlaveTwoTalon.follow(rightMasterTalon);

    leftMasterTalon.configFactoryDefault();
    leftSlaveOneTalon.configFactoryDefault();
    leftSlaveTwoTalon.configFactoryDefault();
    leftSlaveOneTalon.follow(leftMasterTalon);
    leftSlaveTwoTalon.follow(leftMasterTalon);

    differentialDrive = 
    new DifferentialDrive((SpeedController)leftMasterTalon,
     (SpeedController)rightMasterTalon);
  }

  private void CreateSparkDriveBase(int leftMasterId, int leftSlaveIdOne, int leftSlaveIdTwo,
  int rightMasterId, int rightSlaveIdOne, int rightSlaveIdTwo)
  {    
    leftSparkOne = new Spark(leftMasterId);    
    leftSparkTwo = new Spark(leftSlaveIdOne);
    leftSparkThree = new Spark(leftSlaveIdTwo);
    rightSparkOne = new Spark(rightMasterId);
    rightSparkTwo = new Spark(rightSlaveIdOne);
    rightSparkThree = new Spark(rightSlaveIdTwo);

    leftSparkOne.setInverted(true);
    leftSparkTwo.setInverted(true);
    leftSparkThree.setInverted(true);

    differentialDrive = 
    new DifferentialDrive(
     new SpeedControllerGroup(rightSparkOne, rightSparkTwo, rightSparkThree),
     new SpeedControllerGroup(leftSparkOne, leftSparkTwo, leftSparkThree));
  }

  public DriveBase(int leftMasterId, int leftSlaveIdOne, int leftSlaveIdTwo,
   int rightMasterId, int rightSlaveIdOne, int rightSlaveIdTwo, int gearForward, int gearReverse,  SpeedControllerType type) {
    gearDoubleSolenoid = new DoubleSolenoid(gearForward, gearReverse);
    gearDoubleSolenoid.set(Value.kForward);

    switch (type)
    {
      case TALONSRX:
        CreateTalonSRXDriveBase(leftMasterId, leftSlaveIdOne, leftSlaveIdTwo, rightMasterId, rightSlaveIdOne, rightSlaveIdTwo);
        break;
      case SPARKMAX:
        break;
      case SPARK:
        CreateSparkDriveBase(leftMasterId, leftSlaveIdOne, leftSlaveIdTwo, rightMasterId, rightSlaveIdOne, rightSlaveIdTwo);
        break;
      default:
        break;
    }
  }

  public void drive(double velocity, double heading)
  {
    differentialDrive.arcadeDrive(velocity, heading);
  }

  public void toggleShift()
  {
      if (gearDoubleSolenoid.get() == Value.kForward)
      {
        gearDoubleSolenoid.set(Value.kReverse);
      }
      else{
        gearDoubleSolenoid.set(Value.kForward);
      }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new OperatorControl());
  }
}
