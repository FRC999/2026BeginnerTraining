// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IMUsubsystem extends SubsystemBase {
  /** Creates a new IMUsubsystem. */
  private final TalonSRX talon = new TalonSRX(4);
  private final PigeonIMU pigeon = new PigeonIMU(talon);

  public IMUsubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double[] ypr = new double[3]; // yaw, pitch, roll
    pigeon.getYawPitchRoll(ypr);

    System.out.println("Yaw: %.2f  Pitch: %.2f  Roll: %.2f%n" + ypr[0] + " " + ypr[1] + " " + ypr[2]);
    SmartDashboard.putNumber("Yaw", ypr[0]);
    SmartDashboard.putNumber("Pitch", ypr[1]);
    SmartDashboard.putNumber("Roll", ypr[2]);

  }
}
