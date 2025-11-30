// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private DifferentialDrive chassis;
  private SparkMax leftMotor;
  private SparkMax rightMotor;
  private SparkMaxConfig leftConfigs;
  private SparkMaxConfig rightConfigs;

  public DriveSubsystem() {
    leftMotor = new SparkMax(57, SparkMax.MotorType.kBrushless);
    rightMotor = new SparkMax(54, SparkMax.MotorType.kBrushless);
    
    leftConfigs = new SparkMaxConfig();
    rightConfigs = new SparkMaxConfig();
    
    leftMotor.configure(leftConfigs, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    rightMotor.configure(rightConfigs, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);

    chassis = new DifferentialDrive(leftMotor, rightMotor);

    SendableRegistry.addChild(chassis, leftMotor);
    SendableRegistry.addChild(chassis, rightMotor);

    leftMotor.getEncoder().setPosition(0);
    rightMotor.getEncoder().setPosition(0);
  }

  public double getLeftEncoder(){
    return (leftMotor.getEncoder().getPosition()) / 6;
    //Returning in Feet
  }

  public void move(double x, double y){
    // Code to move the motors based on x and y values
    chassis.arcadeDrive(x, y);
  }

  public void stopMotor() {
    // Code to stop the motors
    chassis.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
