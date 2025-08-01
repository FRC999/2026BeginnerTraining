// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final double maxVelocity = 55; //in ticks/second. Normal speed is .58
  public static final double maxAcceleration = 200;
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class PIDConstants {
    public static final double kP = .05; //was originally 1/60
    public static final double kI = 0.0;
    public static final double kD = 0.0;

  }

  public static class TrapezoidProfileConstants {
    public static final double maxVelovity = 1.0;
    public static final double maxAcceleration = .1;

  }
}
