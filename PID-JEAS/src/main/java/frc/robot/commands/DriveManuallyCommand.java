// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveManuallyCommand extends Command {

  public DoubleSupplier move;
  public DoubleSupplier turn;

  /** Creates a new RunMotorCommand. */
  public DriveManuallyCommand(DoubleSupplier move, DoubleSupplier turn) {
    addRequirements(RobotContainer.driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
    this.move = move;
    this.turn = turn;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.driveSubsystem.robotDrive(turn.getAsDouble(), move.getAsDouble()*-1);
    System.out.println("Move: " + move.getAsDouble() + "|| Turn: " + turn.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
