// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Inches;
import static edu.wpi.first.units.Units.KilogramSquareMeters;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Pigeon2Configuration;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;
import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.swerve.SwerveModuleConstants.ClosedLoopOutputType;
import com.ctre.phoenix6.swerve.SwerveModuleConstants.DriveMotorArrangement;
import com.ctre.phoenix6.swerve.SwerveModuleConstants.SteerFeedbackType;
import com.ctre.phoenix6.swerve.SwerveModuleConstants.SteerMotorArrangement;
import com.ctre.phoenix6.swerve.SwerveModuleConstantsFactory;

import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.MomentOfInertia;
import edu.wpi.first.units.measure.Voltage;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class SwerveConstants {
    public static final double MaxSpeed = 5.21; // m/s
    public static final double MaxAngularRate = 4.71238898038469; // rad/s
    public static final double DeadbandRatioLinear = 0.05; // determined by calibration method
    public static final double DeadbandRatioAngular = 0.05; // determined by calibration method

    public static final CANBus kCANBus = new CANBus("", "./logs/example.hoot");
    public static final Pigeon2Configuration pigeonConfigs = null;
    public static final Slot0Configs steerGains = new Slot0Configs()
        .withKP(100).withKI(0).withKD(0.5)
        .withKS(0.1).withKV(2.66).withKA(0)
        .withStaticFeedforwardSign(StaticFeedforwardSignValue.UseClosedLoopSign);
    public static final Slot0Configs driveGains = new Slot0Configs()
        .withKP(0.1).withKI(0).withKD(0)
        .withKS(0).withKV(0.124);
    public static final TalonFXConfiguration steerInitialConfigs = new TalonFXConfiguration()
        .withCurrentLimits(
            new CurrentLimitsConfigs()
                // Swerve azimuth does not require much torque output, so we can set a
                // relatively low
                // stator current limit to help avoid brownouts without impacting performance.
                .withStatorCurrentLimit(Amps.of(60))
                .withStatorCurrentLimitEnable(true));
    public static final TalonFXConfiguration driveInitialConfigs = new TalonFXConfiguration();
    public static final CANcoderConfiguration encoderInitialConfigs = new CANcoderConfiguration();

    // Added from original TunerConstants (auto-merged):

    // Auto-merged constant declarations from original TunerConstants:
    public static final double kCoupleRatio = 3.5714285714285716;
    public static final ClosedLoopOutputType kDriveClosedLoopOutput = ClosedLoopOutputType.Voltage;
    public static final Voltage kDriveFrictionVoltage = Volts.of(0.2);
    public static final double kDriveGearRatio = 6.122448979591837 * (1.00 / 0.9);
    public static final MomentOfInertia kDriveInertia = KilogramSquareMeters.of(0.01);
    public static final DriveMotorArrangement kDriveMotorType = DriveMotorArrangement.TalonFX_Integrated;
    public static final int kPigeonId = 15;
    public static final Current kSlipCurrent = Amps.of(120.0);
    public static final LinearVelocity kSpeedAt12Volts = MetersPerSecond.of(5.21);
    public static final ClosedLoopOutputType kSteerClosedLoopOutput = ClosedLoopOutputType.Voltage;
    public static final SteerFeedbackType kSteerFeedbackType = SteerFeedbackType.FusedCANcoder;
    public static final Voltage kSteerFrictionVoltage = Volts.of(0.2);
    public static final double kSteerGearRatio = 21.428571428571427;
    public static final MomentOfInertia kSteerInertia = KilogramSquareMeters.of(0.01);
    public static final SteerMotorArrangement kSteerMotorType = SteerMotorArrangement.TalonFX_Integrated;
    public static final Distance kWheelRadius = Inches.of(2);

    public static SwerveModuleConstantsFactory<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> ConstantCreator = new SwerveModuleConstantsFactory<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration>()
        .withDriveMotorGearRatio(kDriveGearRatio)
        .withSteerMotorGearRatio(kSteerGearRatio)
        .withCouplingGearRatio(kCoupleRatio)
        .withWheelRadius(kWheelRadius)
        .withSteerMotorGains(steerGains)
        .withDriveMotorGains(driveGains)
        .withSteerMotorClosedLoopOutput(kSteerClosedLoopOutput)
        .withDriveMotorClosedLoopOutput(kDriveClosedLoopOutput)
        .withSlipCurrent(kSlipCurrent)
        .withSpeedAt12Volts(kSpeedAt12Volts)
        .withDriveMotorType(kDriveMotorType)
        .withSteerMotorType(kSteerMotorType)
        .withFeedbackSource(kSteerFeedbackType)
        .withDriveMotorInitialConfigs(driveInitialConfigs)
        .withSteerMotorInitialConfigs(steerInitialConfigs)
        .withEncoderInitialConfigs(encoderInitialConfigs)
        .withSteerInertia(kSteerInertia)
        .withDriveInertia(kDriveInertia)
        .withSteerFrictionVoltage(kSteerFrictionVoltage)
        .withDriveFrictionVoltage(kDriveFrictionVoltage);
    public static final SwerveDrivetrainConstants DrivetrainConstants = new SwerveDrivetrainConstants()
        .withCANBusName(kCANBus.getName())
        .withPigeon2Id(kPigeonId)
        .withPigeon2Configs(pigeonConfigs);

 /** Module wiring and offsets: MOD0..MOD3 */
      public static record SwerveModConstantsRecords(int driveMotorID, int angleMotorID, int cancoderID, double angleOffset,
        boolean driveMotorInverted, boolean angleMotorInverted, boolean cancoderInverted) {}

      public static final SwerveModConstantsRecords MOD0 = new SwerveModConstantsRecords(
        1, 
        2, 
        20, 
        -0.282470578125, 
        false, 
        true, 
        false);
      public static final SwerveModConstantsRecords MOD1 = new SwerveModConstantsRecords(
        3, 
        4, 
        21, 
        0.029541015625, 
        true, 
        true, 
        false);
      public static final SwerveModConstantsRecords MOD2 = new SwerveModConstantsRecords(
        5, 
        6, 
        22, 
        0.317138875, 
        false, 
        true, 
        false);
      public static final SwerveModConstantsRecords MOD3 = new SwerveModConstantsRecords(
        7, 
        8, 
        23, 
        0.044677734375, 
        true, 
        true, 
        false);
  }
}
