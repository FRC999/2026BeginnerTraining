
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import frc.robot.Constants.SwerveConstants;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveManuallyCommand extends Command {

  private final DoubleSupplier mxSupplier;
	private final DoubleSupplier mySupplier;
	private final DoubleSupplier mOmegaSupplier;
  

  /** Creates a new DriveManuallyCommand. */
  public DriveManuallyCommand(DoubleSupplier x, DoubleSupplier y, DoubleSupplier omega) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveSubsystem);
    mxSupplier = x;
    mySupplier = y;
    mOmegaSupplier = omega;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xInput = mxSupplier.getAsDouble();
    double yInput = mySupplier.getAsDouble();
    double omegaInput = mOmegaSupplier.getAsDouble();

    // If alliance is red, axis gets switched, x becomes -x and y becomes -y. redriver |field| bluedriver 
    if (RobotContainer.isAllianceRed) {
      xInput = -xInput;
      yInput = -yInput;
    }

    // Only fieldcentric, no robot centric needed
    RobotContainer.driveSubsystem.drive(
      xInput * SwerveConstants.MaxSpeed,
     //0,
      yInput * SwerveConstants.MaxSpeed,
      //0
      omegaInput * SwerveConstants.MaxAngularRate

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
