// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsytem extends SubsystemBase {
  
  WPI_TalonSRX motor1 = new WPI_TalonSRX(9);
  
  /** Creates a new MotorSubsytem. */
  public MotorSubsytem() {
  

  }

public void startMotor() {
  motor1.set(-0.3);


public void stopMotor() {
  motor1.set(0);

}
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
