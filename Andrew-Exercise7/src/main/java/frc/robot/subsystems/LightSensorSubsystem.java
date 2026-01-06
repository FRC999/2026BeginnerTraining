// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.GregorianCalendar;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorSensorV3.RawColor;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LightSensorSubsystem extends SubsystemBase {
  /** Creates a new LightSensorSubsystem. */
  ColorSensorV3 sensor;
  private final ColorMatch colorMatcher = new ColorMatch();
  private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
  private final Color kGreenTarget = new Color(0.197, 0.561, 0.240);
  private final Color kRedTarget = new Color(0.561, 0.232, 0.114);
  private final Color kYellowTarget = new Color(0.361, 0.524, 0.113);


  public LightSensorSubsystem() {
    sensor = new ColorSensorV3(I2C.Port.kMXP);

    colorMatcher.addColorMatch(kBlueTarget);
    colorMatcher.addColorMatch(kGreenTarget);
    colorMatcher.addColorMatch(kRedTarget);
    colorMatcher.addColorMatch(kYellowTarget);
  }

  public String getSeenColor(Color color) {   // It will return most closely matched color as ENUM
    ColorMatchResult match = colorMatcher.matchClosestColor(color);
    String colorString;
    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
    return colorString;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (getSeenColor(kBlueTarget) == "Blue") {
        SmartDashboard.putString("Color", "Blue");
    } else if (getSeenColor(kRedTarget) == "Red") {
        SmartDashboard.putString("Color", "Red");
    } else if (getSeenColor(kYellowTarget) == "Yellow") {
        SmartDashboard.putString("Color", "Yellow");
    } else if (getSeenColor(kGreenTarget) == "Green") {
        SmartDashboard.putString("Color", "Green");
    }
    
    
    SmartDashboard.putNumber("Proximity", sensor.getProximity());
  }
}
