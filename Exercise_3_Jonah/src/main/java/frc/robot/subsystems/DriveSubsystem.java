// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSubsystem extends SubsystemBase {

private SparkMax leftMotor;
private SparkMax rightMotor;
private DifferentialDrive chassis;
private SparkMaxConfig leftConfig = new SparkMaxConfig();
private SparkMaxConfig rightConfig = new SparkMaxConfig();

public DriveSubsystem() {
 leftMotor = new SparkMax(54, MotorType.kBrushless);
 rightMotor = new SparkMax(57, MotorType.kBrushless);
 leftConfig.inverted(true);
 rightConfig.inverted(false);
 leftMotor.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
 rightMotor.configure(rightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    chassis = new DifferentialDrive(leftMotor, rightMotor);
 }
 public void drive(double y, double z){
   chassis.arcadeDrive(y, z);
 } 


@Override
public void periodic() {
  // This method will be called once per scheduler run
}
}



