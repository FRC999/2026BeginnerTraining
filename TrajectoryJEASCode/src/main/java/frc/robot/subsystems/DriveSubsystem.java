// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private static SparkMax leftMotor;
  private static SparkMax rightMotor;
  private static SparkMaxConfig configRight;
  private static SparkMaxConfig configLeft; 

  private RelativeEncoder leftMotorEncoder; 
  private RelativeEncoder rightMotorEncoder;


  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    leftMotor = new SparkMax(57, MotorType.kBrushless);
    rightMotor = new SparkMax(54, MotorType.kBrushless);

    leftMotorEncoder = leftMotor.getEncoder();
    rightMotorEncoder = rightMotor.getEncoder();

    configRight = new SparkMaxConfig();
    configLeft = new SparkMaxConfig();

    configureMotors();
  }

  private void configureMotors() {
    configRight.idleMode(IdleMode.kBrake);
    configLeft.idleMode(IdleMode.kBrake);
    leftMotor.configure(configLeft, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    configRight.inverted(true);
    rightMotor.configure(configRight, SparkBase.ResetMode.kResetSafeParameters,
        SparkBase.PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
