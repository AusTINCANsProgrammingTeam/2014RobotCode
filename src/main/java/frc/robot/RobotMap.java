/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final int LEFT_MOTOR_1 = 4;
  public static final int LEFT_MOTOR_2 = 5;
  public static final int LEFT_MOTOR_3 = 6;

  public static final int RIGHT_MOTOR_1 = 1;
  public static final int RIGHT_MOTOR_2 = 2;
  public static final int RIGHT_MOTOR_3 = 3;

  //GearMode for drive

  public static final int PCM_ADRESS = 0;
  
  public static final int GEARBOX_FOWARD_CHANNEL = 0;
  public static final int GEARBOX_REVERSE_CHANNEL = 1;


  public static final int LEFT_PISTION_FOWARD = 6;
  public static final int LEFT_PISTON_REVERSE = 7;
 
  public static final int RIGHT_PISTON_FOWARD = 4;
  public static final int RIGHT_PISTON_REVERSE = 5;

  public static final int ARM_INTAKE_MOTOR = 8;

  public static final int CAT_FOWARD = 2;
  public static final int CAT_REVERSE = 3;


  public static final int CAT_MOTOR = 7;

}
