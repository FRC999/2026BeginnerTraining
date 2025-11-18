// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;


 public class DrivetrainSubsystem extends SubsystemBase {
 private static final int leadDeviceID = 54;

 private static final int followDeviceID = 57;
  
 private static final int kJoystickPort = 0;
  
 private SparkMax m_leadMotor;
 private SparkMax m_followMotor;
 private Joystick m_joystick;

 
 public void robotInit() {
 m_leadMotor = new SparkMax(leadDeviceID, MotorType.kBrushless);
 m_followMotor = new SparkMax(followDeviceID, MotorType.kBrushless);
 
 m_leadMotor.configure(null, null, null);
 m_followMotor.follow(leadDeviceID);
 

 
 m_leadMotor.set(m_joystick.getY());

}
 
    // This method will be called once per scheduler run
  }

