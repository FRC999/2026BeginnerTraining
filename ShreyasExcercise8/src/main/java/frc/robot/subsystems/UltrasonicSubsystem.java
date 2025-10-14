// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class UltrasonicSubsystem extends SubsystemBase {

  private static final AnalogInput sensor = new AnalogInput(2);

  double voltage_scale_factor = 5/RobotController.getVoltage5V();


  /** Creates a new UltrasonicSubsystem. */
  public UltrasonicSubsystem() {}

  public static double getDistance() {
      return sensor.getValue();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Ultrasonic: ", getDistance());  
  }
}
