/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Constants {
  public static final double kIntakeOut = -.75;
  public static final double kIntakeIn = .75;
  


  public static final int kNumSensorUnitsPerRotation = 4096;
  public static final double kTurnTravelUnitsPerRotation = 3600;
  public static final int kEncoderUnitsPerRotation = 51711;
  public static final int kTimeOutMs = 10;
  public static final double kNeutralDeadband = 0.001;

  public final static Gains kGains_Distance = new Gains( 0.0, 0.0, 0.0,     100,  .5);

  public final static int REMOTE_0 = 0;
  public final static int REMOTE_1 = 1;
  public final static int PID_PRIMARY = 0;
  public final static int PID_TURN = 1;
  public final static int SLOT_0 = 0;
  public final static int SLOT_1 = 1;
  public final static int SLOT_2 = 2;
  public final static int SLOT_3 = 3;


  public final static int kSlot_Distance = SLOT_0;
  public final static int kSlot_Turning = SLOT_1;
  public final static int kSlot_Velocity = SLOT_2;
  public final static int kSlot_MotProf = SLOT_3;
}
