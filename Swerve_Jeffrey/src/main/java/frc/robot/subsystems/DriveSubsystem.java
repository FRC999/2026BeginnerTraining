// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Inches;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.swerve.SwerveDrivetrain;
import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants.SwerveConstants;
import frc.robot.Constants.SwerveConstants.SwerveModConstantsRecords;

public class DriveSubsystem extends SwerveDrivetrain<TalonFX, TalonFX, CANcoder> implements Subsystem {
  /** Creates a new DriveSubsystem. */
  Pigeon2 imu;

  // Someone explain what this does
   private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
      .withDeadband(SwerveConstants.MaxSpeed * SwerveConstants.DeadbandRatioLinear).withRotationalDeadband(SwerveConstants.MaxAngularRate * SwerveConstants.DeadbandRatioAngular); // Add a 10% deadband;

  public static DriveSubsystem driveTrain() {
    return new DriveSubsystem(
      SwerveConstants.DrivetrainConstants,
      SwerveConstants.ConstantCreator.createModuleConstants(
        SwerveConstants.MOD0.angleMotorID(), 
        SwerveConstants.MOD0.driveMotorID(),
        SwerveConstants.MOD0.cancoderID(), 
        Rotations.of(SwerveConstants.MOD0.angleOffset()), 
        Inches.of(10.335), Inches.of(10.335), 
        SwerveConstants.MOD0.driveMotorInverted(),
        SwerveConstants.MOD0.angleMotorInverted(),
        SwerveConstants.MOD0.cancoderInverted()),
      SwerveConstants.ConstantCreator.createModuleConstants(
        SwerveConstants.MOD1.angleMotorID(), 
        SwerveConstants.MOD1.driveMotorID(),
        SwerveConstants.MOD1.cancoderID(), 
        Rotations.of(SwerveConstants.MOD1.angleOffset()), 
        Inches.of(10.335), Inches.of(10.335), 
        SwerveConstants.MOD1.driveMotorInverted(),
        SwerveConstants.MOD1.angleMotorInverted(),
        SwerveConstants.MOD1.cancoderInverted()),
      SwerveConstants.ConstantCreator.createModuleConstants(
        SwerveConstants.MOD2.angleMotorID(), 
        SwerveConstants.MOD2.driveMotorID(),
        SwerveConstants.MOD2.cancoderID(), 
        Rotations.of(SwerveConstants.MOD2.angleOffset()), 
        Inches.of(10.335), Inches.of(10.335), 
        SwerveConstants.MOD2.driveMotorInverted(),
        SwerveConstants.MOD2.angleMotorInverted(),
        SwerveConstants.MOD2.cancoderInverted()), 
      SwerveConstants.ConstantCreator.createModuleConstants(
        SwerveConstants.MOD3.angleMotorID(), 
        SwerveConstants.MOD3.driveMotorID(),
        SwerveConstants.MOD3.cancoderID(), 
        Rotations.of(SwerveConstants.MOD3.angleOffset()), 
        Inches.of(10.335), Inches.of(10.335), 
        SwerveConstants.MOD3.driveMotorInverted(),
        SwerveConstants.MOD3.angleMotorInverted(),
        SwerveConstants.MOD3.cancoderInverted()));
  }

  public DriveSubsystem( 
            SwerveDrivetrainConstants drivetrainConstants,
            SwerveModuleConstants<?, ?, ?>... modules) {
    super( 
        TalonFX::new, TalonFX::new, CANcoder::new,
        drivetrainConstants, modules);
    CommandScheduler.getInstance().registerSubsystem(this);
    imu = this.getPigeon2();
  }

  // Completely no idea what this does, someone pls help review
  public void drive(double xVelocity_m_per_s, double yVelocity_m_per_s, double omega_rad_per_s) {
    //System.out.println("X: " + xVelocity_m_per_s + " y: " + yVelocity_m_per_s + " o:" + omega_rad_per_s/SwerveChassis.MaxAngularRate);
    //SmartDashboard.putString("Manual Drive Command Velocities","X: " + xVelocity_m_per_s + " y: " + yVelocity_m_per_s + " o:" + omega_rad_per_s);
    this.setControl(
      drive.withVelocityX(xVelocity_m_per_s)
        .withVelocityY(yVelocity_m_per_s)
        .withRotationalRate(omega_rad_per_s)
    );
    // previousOmegaRotationCommand = omega_rad_per_s / SwerveChassis.MaxAngularRate;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}