/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
* Index and Intake subsystem!
* @author Appw
* @version -1.0
 */
public class Index extends SubsystemBase {
  private static double indexSpeed = 0.5d; // TODO: move to constants.java
  private static double timeForConsume = 1.0d; // TODO: move to constants.java
  private WPI_TalonSRX indexMotor;
  private WPI_TalonSRX intakeMotor;

  /**
  * Constructor for the Index subsystem.
  */
  public Index() {
    indexMotor = new WPI_TalonSRX(4); // TODO: move to constants.java
    intakeMotor = new WPI_TalonSRX(5); // TODO: move to constants.java
  }

  /**
  * Input game piece from the Intake system, one at a time only.
  */
  public void consume() {
  }

  /**
  * Removes game pieces from the Index system.
  *
  * @param reverse If true, the direction of removal and the Intake system are reversed. If not provided, false is assumed.
  * @param amount Amount of pieces to remove. If not provided, one piece is assumed.
  */
  public void remove(boolean reverse, int amount) {
  }

  public void remove(boolean reverse) {
    remove(reverse, 1);
  }

  public void remove(int amount) {
    remove(false, amount);
  }

  public void remove() {
    remove(false, 1);
  }

  /**
  * Removes all game pieces from the Index system.
  * @param reverse If true, the direction of removal and the Intake system are reversed. If not provided, false is assumed.
  */
  public void removeAll(boolean reverse) {
  }

  public void removeAll() {
    removeAll(false);
  }

  /**
  * Stops all movement of the Index system.
  */
  public void stop() {
  }

  /**
  * Stops all movement of the Index and Intake system.
  */
  public void stopAll() {
    stop();
  }

  /**
  * Sets the status of the Intake system.
  * @param enabled The enabled status of the Intake. If not provided, the status will be toggled.
  * @param reverse If true, the direction of the Intake will be reversed. If not provided, false is assumed.
  */
  public void setIntake(boolean enabled, boolean reverse) {
  }

  public void setIntake(boolean enabled) {
    setIntake(enabled, false);
  }

  public void setIntake() {
    setIntake(false, false); // TODO: actually make this function
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
