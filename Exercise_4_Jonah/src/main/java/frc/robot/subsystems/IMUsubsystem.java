// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IMUsubsystem extends SubsystemBase {
  /** Creates a new IMUsubsystem. */
  public IMUsubsystem() {}
  TalonSRX _talon2 = new TalonSRX(4);
  PigeonIMU _pigeon = new PigeonIMU(_talon2);

  

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
   double[] ypr = new double[3];
     _pigeon.getYawPitchRoll(ypr);
     System.out.println("Yaw:"+ ypr[0] + "Pitch:" + ypr[1] + "Roll:" + ypr[2]);
  }
    
  
}
