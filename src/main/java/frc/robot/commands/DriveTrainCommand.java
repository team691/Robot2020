/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
public class DriveTrainCommand extends CommandBase {
private int invDrive = 0;
private boolean driveInv = false;
  /**
   * Creates a new DriveTrainCommand.
   */
  public DriveTrainCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if (RobotContainer.j.getRawButtonPressed(2) && invDrive == 0){
    //   invDrive = 1;
    // } 
    // if (RobotContainer.j.getRawButtonPressed(2) && invDrive == 1) {
    //   invDrive = 0;
    // }
    // if (invDrive == 0){
    //   RobotContainer.dt.arcadeDrive(RobotContainer.j.getY(), RobotContainer.j.getX());
    // }
    // if (invDrive == 1){
    //   RobotContainer.dt.inverseDrive(RobotContainer.j.getY(), RobotContainer.j.getX());
    // }
    if (RobotContainer.j.getRawButtonPressed(2)) {
      driveInv = !driveInv;
    }

    if (driveInv) {
      RobotContainer.dt.inverseDrive(RobotContainer.j.getY(), RobotContainer.j.getX());
    } else {
      RobotContainer.dt.arcadeDrive(RobotContainer.j.getY(), RobotContainer.j.getX());
    }
  }

  
}
