// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsytem extends SubsystemBase {
  
  WPI_TalonSRX motor1 = new WPI_TalonSRX(9);
  SparkMax motor2 = new SparkMax(54, MotorType.kBrushless);
  SparkMax motor3 = new SparkMax(57, MotorType.kBrushless);

  private SparkMaxConfig motorConfig;

  /* Creates a new MotorSubsytem. */
  public MotorSubsytem() {
  
    //  motor3.follow(motor2);

    motorConfig = new SparkMaxConfig();
    motorConfig.follow(motor2, true);

    motor3.configure(motorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    

  }

public void startMotor() {
  motor2.set(-0.3);
  
}


public void stopMotor() {
  motor2.set(0);

}
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
