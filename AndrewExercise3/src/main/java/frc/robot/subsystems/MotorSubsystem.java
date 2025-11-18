// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {

  private SparkMax m_rightMotor;
  private SparkMax m_leftMotor;
  private SparkMaxConfig configLeft = new SparkMaxConfig();
  private SparkMaxConfig configRight = new SparkMaxConfig();
  private DifferentialDrive m_drive;
  
  
  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {
    m_rightMotor = new SparkMax(57, MotorType.kBrushless); // CAN ID placeholders
    m_leftMotor = new SparkMax(54, MotorType.kBrushless);
    configLeft
      .inverted(true);
    m_leftMotor.configure(configLeft, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_rightMotor.configure(configRight, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    //m_leftMotor.setInverted(true); 
  }

  public void drive (double x, double y) {
    m_drive.arcadeDrive(x, y);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
