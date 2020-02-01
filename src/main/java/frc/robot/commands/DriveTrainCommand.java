package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveTrainCommand extends CommandBase {
  public DriveTrainCommand() { }

  @Override
  public void execute() {
    RobotContainer.dt.arcadeDrive(RobotContainer.j.getX(), RobotContainer.j.getY());
  }
}
