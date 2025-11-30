// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveManuallyCommand extends Command {
  public DoubleSupplier mX;
  public DoubleSupplier mY;
  public DoubleSupplier mRot;

  /** Creates a new DriveManuallyCommand. */
  public DriveManuallyCommand(DoubleSupplier x, DoubleSupplier y, DoubleSupplier rot) {
    addRequirements(RobotContainer.driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.

    mX = x;
    mY = y;
    mRot = rot;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the s cheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xInput = mX.getAsDouble();
    double yInput = mY.getAsDouble();
    double rotInput = mRot.getAsDouble();

    RobotContainer.driveSubsystem.drive(
      xInput * Constants.SwerveConstants.MaxSpeed, 
      yInput * Constants.SwerveConstants.MaxSpeed, 
      rotInput * Constants.SwerveConstants.MaxAngularRate
    );
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
