// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;
import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;

import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.simulation.SimDeviceSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IMUSubstystem extends SubsystemBase {
  /** Creates a new IMUSubstystem. */
  WPI_TalonSRX _talon = new WPI_TalonSRX(4); //placeholder number 
  WPI_PigeonIMU _pigeon = new WPI_PigeonIMU(_talon);


  AHRS m_navx = new AHRS(NavXComType.kMXP_SPI);
  public IMUSubstystem() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
     double[] ypr = new double[3];
      _pigeon.getYawPitchRoll(ypr);
    
      SmartDashboard.putNumber("Pigeon Yaw", ypr[0]);
      SmartDashboard.putNumber("Pigeon Pitch", ypr[1]);
      SmartDashboard.putNumber("Pigeon Roll", ypr[2]); 
       
      SmartDashboard.putNumber("NavX Yaw", m_navx.getYaw());
      SmartDashboard.putNumber("NavX Pitch", m_navx.getRoll());
      SmartDashboard.putNumber("NavX Roll", m_navx.getPitch());     
  }
}
