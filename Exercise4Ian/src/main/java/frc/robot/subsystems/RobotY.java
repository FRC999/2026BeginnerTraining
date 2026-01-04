// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class RobotY extends SubsystemBase {

    private TalonSRX talon = new TalonSRX(4);
    private PigeonIMU pigeon1 = new PigeonIMU(talon);
    
  /** Creates a new Robot. */
  public RobotY() {}

public double getYaw() {
  double[] ypr = new double[3];
  pigeon1.getYawPitchRoll(ypr);
  return ypr[0];
  
}

 public double getPitch() {
  double[] ypr = new double[3];
  pigeon1.getYawPitchRoll(ypr);
  return ypr[1];

 }

  public double getRoll() {
  double[] ypr = new double[3];
  pigeon1.getYawPitchRoll(ypr);
  return ypr[2];
  }
//void resetYaw() {
 // pigeon1.setYaw(0);
//}
  @Override
  public void periodic() {


System.out.printf("Yaw:" + getYaw(), "Pitch:" + getPitch(), "Roll:" + getRoll());

SmartDashboard.putString("IMU","Yaw:" + getYaw()+ "Pitch:" + getPitch()+ "Roll:" + getRoll());
    
    // This method will be called once per scheduler run
  }
}
