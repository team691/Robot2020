/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DriverStation;
 
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class ColorWheel extends SubsystemBase {
  private final I2C.Port i2cPort = I2C.Port.kOnboard;

  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher   = new ColorMatch();
 
  private final Color kBlueTarget   = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget  = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget    = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  private Talon motor = new Talon(4);
  private Talon raise = new Talon(5);

  private final double MOTOR_SPEED = 0.8;
  private String fieldColor        = "";
  private int changeCount          = 0;
  private String tempColor         = "";
  private String gameData          = "";
  private boolean raised           = false;
  /**
   * Creates a new ColorWheel.
   */
  public ColorWheel() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  public void check() {
    checkPositionalControl();
    checkRotationalControl();
  }

  public String getColor() {
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
 
    if (match.color == kBlueTarget) {
      return "Blue";
    } else if (match.color == kRedTarget) { 
      return "Red";
    } else if (match.color == kGreenTarget) {
      return "Green";
    } else if (match.color == kYellowTarget) {
      return "Yellow";
    }
    return "Unknown";
  }

  public void getFieldColor() {
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if (gameData.length() > 0) {
      switch (gameData.charAt(0)) {
        case 'B' :
        fieldColor = "Blue";
        break;
        case 'G' :
        fieldColor = "Green";
        break;
        case 'R' :
        fieldColor = "Red";
        break;
        case 'Y' :
        fieldColor = "Yellow";
        break;
        default :
        break;
      }

    }
  }
  
  public void rotateColorWheel() {
    motor.set(MOTOR_SPEED);
  }

  public void elevColorWheel() {
    if (raised) {
      raise.set(-0.5);
      raised = false;
    } else {
      raise.set(0.5);
      raised = true;
    }
  }
 
  public void positionalControl() {
    changeCount = 0;
    getFieldColor();
    motor.set(MOTOR_SPEED);
    
  }

  public void checkPositionalControl() {
    if (getColor().equals(alternateColor(fieldColor))) {
      stopColorWheel();
      fieldColor = "";
    }
  }

  public void rotationalControl() {
    fieldColor = "";
    motor.set(MOTOR_SPEED);
    tempColor = getColor();
  }

  public void checkRotationalControl() {
    if (!tempColor.equals(getColor())) {
      changeCount++;
    }
    if (changeCount > 21) {
      stopColorWheel();
      changeCount = 0;
    }
  }

  public String alternateColor(String color) {
    if (color.equals("Red")) {
      return "Blue";
    } else if (color.equals("Blue")) {
      return "Red";
    } else if (color.equals("Yellow")) {
      return "Green";
    } else if (color.equals("Green")) {
      return "Yellow";
    }
    return "";
  }
  public void stopColorWheel() {
    motor.set(0);
  }
}
