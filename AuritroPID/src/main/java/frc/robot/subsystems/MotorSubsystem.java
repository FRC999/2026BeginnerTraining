// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicDutyCycle;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
  /** Creates a new MotorSubsystem. */
  
  private TalonFX motor;
 
  public MotorSubsystem() {
    

  
  MotionMagicDutyCycle motMagDutyCycle = new MotionMagicDutyCycle(0);
  MotionMagicVoltage motMagVoltage = new MotionMagicVoltage(0);
  PositionVoltage positionVoltage = new PositionVoltage(0).withSlot(0);

  motor=new TalonFX(1);
  }
  public void configureMotor (){
    motor.getConfigurator().apply(new TalonFXConfiguration()); // reset the motor to defaults

    motor.setSafetyEnabled(false);
    
    var talonFXConfiguratorMotor = motor.getConfigurator();

    var motorconfigs = new MotorOutputConfigs();
    motorconfigs.NeutralMode = NeutralModeValue.Brake; 


    TalonFXConfiguration pidConfig = new TalonFXConfiguration().withMotorOutput(motorconfigs);
    
    configureMotionMagicDutyCycle(pidConfig);

  
  private void configureMotionMagicDutyCycle(TalonFXConfiguration config) {
    //config.Slot0.kS = 0.24; // add 0.24 V to overcome friction
    //config.Slot0.kV = 0.12; // apply 12 V for a target velocity of 100 rps
    //PID on Position
    config.Slot0.kP = MotionMagicDutyCycleConstants.elevator_kP;
    config.Slot0.kI = MotionMagicDutyCycleConstants.elevator_kI;
    config.Slot0.kD = MotionMagicDutyCycleConstants.elevator_kD;

    config.MotionMagic.MotionMagicCruiseVelocity = MotionMagicDutyCycleConstants.MotionMagicCruiseVelocity;
    config.MotionMagic.MotionMagicAcceleration = MotionMagicDutyCycleConstants.motionMagicAcceleration;
    config.MotionMagic.MotionMagicJerk = MotionMagicDutyCycleConstants.motionMagicJerk;

    elevatorMotorLeader.getConfigurator().apply(config, 0.050);

    motMagDutyCycle.Slot = MotionMagicDutyCycleConstants.slot;
      private void configureMotionMagicDutyCycle(TalonFXConfiguration config) {
    //config.Slot0.kS = 0.24; // add 0.24 V to overcome friction
    //config.Slot0.kV = 0.12; // apply 12 V for a target velocity of 100 rps
    //PID on Position
    config.Slot0.kP = MotionMagicDutyCycleConstants.elevator_kP;
    config.Slot0.kI = MotionMagicDutyCycleConstants.elevator_kI;
    config.Slot0.kD = MotionMagicDutyCycleConstants.elevator_kD;

    config.MotionMagic.MotionMagicCruiseVelocity = MotionMagicDutyCycleConstants.MotionMagicCruiseVelocity;
    config.MotionMagic.MotionMagicAcceleration = MotionMagicDutyCycleConstants.motionMagicAcceleration;
    config.MotionMagic.MotionMagicJerk = MotionMagicDutyCycleConstants.motionMagicJerk;

    elevatorMotorLeader.getConfigurator().apply(config, 0.050);

    motMagDutyCycle.Slot = MotionMagicDutyCycleConstants.slot;
    
    }
  }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
