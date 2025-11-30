// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class MotorSubsystem extends SubsystemBase {

  TalonSRX motor1 = new TalonSRX(9);

  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {}

public  void StartMotor() {
  motor1.set(ControlMode.PercentOutput, 0.9);

}

public void StopMotor() {

  motor1.set(ControlMode.PercentOutput, 0);
}

public void MoveBackwards() {

  motor1.set(ControlMode.PercentOutput, -0.5);
}

public void StopRetroceding(){

  motor1.set(ControlMode.PercentOutput, 0);
}

public void MoveMotorsWithVariableSpeed(double gg){
motor1.set(ControlMode.PercentOutput, gg);

}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
