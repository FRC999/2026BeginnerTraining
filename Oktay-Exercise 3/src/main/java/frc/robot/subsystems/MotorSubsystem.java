// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;


public class MotorSubsystem extends SubsystemBase {
  

  SparkMax leftMotor = new SparkMax(57, MotorType.kBrushless) ;
  SparkMax rightMotor = new SparkMax(54, MotorType.kBrushless);

  private SparkMaxConfig leftConfig = new SparkMaxConfig();
  private SparkMaxConfig rightConfig = new SparkMaxConfig();

  private DifferentialDrive chasis;
  
  
  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {

    leftConfig.inverted(false);

    rightConfig.inverted(true);
    

    leftMotor.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    rightMotor.configure(rightConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

    chasis = new DifferentialDrive(leftMotor, rightMotor);

  }

  public void drive(double x , double y) {
    chasis.arcadeDrive(x, y);

  }
  
  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
