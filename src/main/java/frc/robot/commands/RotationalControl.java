package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class RotationalControl extends CommandBase {

  //private ColorWheel cw = new ColorWheel();

  public RotationalControl() { }

  @Override
  public void execute() {
    //cw.rotationalControl();
  }

  @Override
  public void end(boolean interrupted) {
    //cw.stopColorWheel();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}