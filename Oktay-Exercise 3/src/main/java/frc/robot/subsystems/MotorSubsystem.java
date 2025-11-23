// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;


public class MotorSubsystem extends SubsystemBase {
  

  SparkMax leftMotor = new SparkMax(57, MotorType.kBrushless) ;
  SparkMax rightMotor = new SparkMax(54, MotorType.kBrushless);

  
  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {

    
    motorConfig = new SparkMaxConfig();   
    
   

  }

 
  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
