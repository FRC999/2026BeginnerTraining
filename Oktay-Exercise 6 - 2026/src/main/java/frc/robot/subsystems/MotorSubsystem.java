// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.ctre.phoenix6.configs.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
  
  
  public SparkMax m_leadMotor = new SparkMax(54, MotorType.kBrushless);
  public SparkMax m_followMotor = new SparkMax(57, MotorType.kBrushless);

  public SparkMaxConfig motorConfig = new SparkMaxConfig();
  

  
  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {




    motorConfig = new SparkMaxConfig();
    motorConfig.follow(m_followMotor, true);


    m_leadMotor.configure(motorConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);

  }

  public void startMotor() {
  m_leadMotor.set(-0.3);
  
}


public void stopMotor() {
  m_leadMotor.set(0);

}




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
