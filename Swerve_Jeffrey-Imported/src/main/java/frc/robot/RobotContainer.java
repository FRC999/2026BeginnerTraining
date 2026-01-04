// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OIConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.StopDrivePPCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

import java.lang.ModuleLayer.Controller;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  public static final DriveSubsystem driveSubsystem = DriveSubsystem.driveTrain();  

  public static final Joystick joystick = new Joystick(0);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  // Creating an xbox controller for swerveDriveTrain
  public static Controller xboxDriveController = new Controller(OIConstants.XBOX_CONTROLLER);

  public static boolean isAllianceRed = false;


  public RobotContainer() {
    configureBindings();
    driveSubsystem.setDefaultCommand(
      new DriveManuallyCommand(
          () -> getDriverXAxis(),
          () -> getDriverYAxis(),
          () -> getDriverOmegaAxis()));
  }



  public void checkIfAllianceIsRed() {
    var alliance = DriverStation.getAlliance();
    isAllianceRed = alliance.get() == DriverStation.Alliance.Red;
  }

     // Driver preferred controls
     private double getDriverXAxis() {
      return -m_driverController.getLeftY();
      //return -xboxDriveController.getRightStickY();
    }
  
    private double getDriverYAxis() {
      return -m_driverController.getLeftX();
      //return -xboxDriveController.getRightStickX();
    }
  
    private double getDriverOmegaAxis() {
      //return -xboxController.getLeftStickOmega();
      //return -xboxDriveController.getLeftStickX();
      return -m_driverController.getRightX();
    }

    public static Command runTrajectoryPathPlannerWithForceResetOfStartingPoseWithVision(String tr,
      boolean shouldResetOdometryToStartingPose, boolean flipTrajectory) {
    try {
      // Load the path you want to follow using its name in the GUI
      PathPlannerPath path = PathPlannerPath.fromPathFile(tr);

      if (flipTrajectory) {
        path = path.flipPath();
      }
      Pose2d startPose = path.getStartingHolonomicPose().get();
      driveSubsystem.setOdometryPoseToSpecificPose(startPose); // reset odometry, as PP may not do so

      // Create a path following command using AutoBuilder. This will also trigger
      // event markers.
      if (! shouldResetOdometryToStartingPose) {
        return AutoBuilder.followPath(path);
      } else { // reset odometry the right way
        return Commands.sequence(AutoBuilder.resetOdom(startPose), AutoBuilder.followPath(path));
      }
    } catch (Exception e) {
      DriverStation.reportError("Big oops: " + e.getMessage(), e.getStackTrace());
      return Commands.none();
    }
  }


  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    new JoystickButton(joystick, 1)
      .onTrue(runTrajectoryPathPlannerWithForceResetOfStartingPoseWithVision("One Meter Forward", true, false))
      .onFalse(new StopDrivePPCommand());

    new JoystickButton(m_driverController, 2)
      .onTrue(new StopDrivePPCommand());

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}