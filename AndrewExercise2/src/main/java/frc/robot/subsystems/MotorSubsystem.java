// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.controls.Follower;
import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

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

    var leadConfig = new SparkMaxConfig();
    var followConfig = new SparkMaxConfig();
    //followerConfig.follow(m_leadMotor);
    m_leadMotor.configure(leadConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    followConfig.follow(54);
    m_followMotor.configure(followConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  public static double clamp(double value, double min, double max) {
    if (value < min) {
        return min;
    } else if (value > max) {
        return max;
    } else {
        return value;
    }
}

  public void startMotor() {
    //System.out.println("**running motor");
    m_leadMotor.set(clamp(RobotContainer.joystick.getRawAxis(3), -0.5, 0.5));
    //m_leadMotor.setVoltage(6);
    //System.out.println("**test2");
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
