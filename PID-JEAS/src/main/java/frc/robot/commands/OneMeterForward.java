// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class OneMeterForward extends Command {
  private double startPos;
  private double endPos;
  private double tolerance = 0.4;

  
  PIDController pid = new PIDController(1.0/60.0, 0, 0);
  /** Creates a new OneMeterForward. */
  public OneMeterForward() {
    addRequirements(RobotContainer.driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("starting forward");
    startPos = RobotContainer.driveSubsystem.leftMotor.getEncoder().getPosition();
    endPos = startPos + 20;
    RobotContainer.driveSubsystem.robotDrive(pid.calculate(RobotContainer.driveSubsystem.leftMotor.getEncoder().getPosition(), endPos),0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double encoder = RobotContainer.driveSubsystem.leftMotor.getEncoder().getPosition();
    double p = pid.calculate(RobotContainer.driveSubsystem.leftMotor.getEncoder().getPosition(), endPos);
    System.out.println("Encoder value: " + encoder + " Power: " + p + " End pos " + endPos);
    RobotContainer.driveSubsystem.robotDrive(pid.calculate(p, endPos),0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("arrived " + interrupted); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Math.abs(RobotContainer.driveSubsystem.leftMotor.getEncoder().getPosition() - endPos) < tolerance);
  }
}
