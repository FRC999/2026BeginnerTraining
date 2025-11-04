// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
  /** Creates a new MotorSubsystem. */
  private SparkMax m_leadMotor;
  private SparkMax m_followMotor;
  

  public MotorSubsystem() {
    m_leadMotor = new SparkMax(54, MotorType.kBrushless);
    m_followMotor = new SparkMax(57, MotorType.kBrushless);
    configureMotor();
  }
  private void configureMotor() {
    var followerConfig = new SparkMaxConfig();
    //followerConfig.follow(m_leadMotor);
    m_followMotor.configure(followerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void startMotor() {
    System.out.println("**running motor");
    m_leadMotor.set(0.3);
    //m_leadMotor.setVoltage(6);
    System.out.println("**test2");
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
