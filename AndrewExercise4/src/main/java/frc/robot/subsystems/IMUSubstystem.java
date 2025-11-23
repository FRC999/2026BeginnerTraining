// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IMUSubstystem extends SubsystemBase {
  /** Creates a new IMUSubstystem. */
  public IMUSubstystem() {
    WPI_TalonSRX _talon = new WPI_TalonSRX(00); //placeholder number 
    WPI_PigeonIMU _pigeon = new WPI_PigeonIMU(_talon);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
