// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class MotorSubsystem extends SubsystemBase {
  private SparkMax m_leadMotor;
  private SparkMax m_followMotor;

  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {
    m_leadMotor=new SparkMax(54, MotorType.kBrushless);
    m_followMotor = new SparkMax(57, MotorType.kBrushless);
    configureMotor();
  }
  private void configureMotor() {
    var leadConfig = new SparkMaxConfig();
    var followConfig = new SparkMaxConfig();
    m_leadMotor.configure(leadConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    followConfig.follow(54);
    m_followMotor.configure(followConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }
  public void startMotor()
  {
    m_leadMotor.set(0.5);
  }
  public void stopMotor()
  {
    m_leadMotor.set(0.5);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
