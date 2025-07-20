// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  public DifferentialDrive chassis;
  public static SparkMax leadMotor;
  public static SparkMax followMotor;
  public static SparkMaxConfig configFollow = new SparkMaxConfig();
  public static SparkMaxConfig configLead = new SparkMaxConfig();

  public DriveSubsystem() {
    leadMotor = new SparkMax(54, MotorType.kBrushless);
    followMotor = new SparkMax(57, MotorType.kBrushless);

    leadMotor.configure(configLead, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    configFollow.inverted(true);
    followMotor.configure(configFollow, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);

    chassis = new DifferentialDrive(leadMotor, followMotor);

    SendableRegistry.addChild(chassis, leadMotor);
    SendableRegistry.addChild(chassis, followMotor);

  }

  public void dynamicSpeedChange(double move1, double move2){
    chassis.tankDrive(move1, move2);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
