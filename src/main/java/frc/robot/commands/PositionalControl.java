package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class PositionalControl extends CommandBase {
  private ColorWheel cw = new ColorWheel();

  public PositionalControl() { }
  
  @Override
  public void execute() {
    cw.positionalControl();
  }

  @Override
  public void end(boolean interrupted) {
    cw.stopColorWheel();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
