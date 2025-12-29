// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class MotorSubsystem extends SubsystemBase {
  /** Creates a new MotorSubsystem. */
  private SparkMax m_leadMotor;


  public MotorSubsystem() {
    m_leadMotor = new SparkMax(54, MotorType.kBrushless);
  }

  public void startMotor() {
    m_leadMotor.set(0.3);
  }
  public void stopMotor() {
    m_leadMotor.set(0);
  }
  public void reverseStartMotor(){
    m_leadMotor.set(-0.3);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
