// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.servohub.ServoHub.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
  
  
  public SparkMax m_leadMotor = new SparkMax(54, MotorType.kBrushless);
  public SparkMax m_followMotor = new SparkMax(57, MotorType.kBrushless);

  private SparkMaxConfig leadConfig = new SparkMaxConfig();
  private SparkMaxConfig followConfig = new SparkMaxConfig();

  
  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {

    leadConfig.inverted(false);

    followConfig.inverted(true);

    m_leadMotor.configure(leadConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    m_followMotor.configure(followConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
