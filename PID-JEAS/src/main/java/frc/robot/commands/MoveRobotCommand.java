// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class MoveRobotCommand extends Command {
  public static int time = 0;
  /** Creates a new MoveRobotCommand. */
  public MoveRobotCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(RobotContainer.driveSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.driveSubsystem.robotDrive(.5,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    time += 20;
    System.out.println("Time(ms): " + time);
    if (time <= 200) {
      RobotContainer.driveSubsystem.robotDrive(.8,0);
    } else {
      RobotContainer.driveSubsystem.robotDrive(Constants.cruisingSpeed,0);
    }
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
