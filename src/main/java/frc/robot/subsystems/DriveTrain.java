//Be competent
package frc.robot.subsystems;

import frc.robot.commands.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.ctre.phoenix.motorcontrol.can.*;

public class DriveTrain extends SubsystemBase {

  private final DriveTrainCommand drive = new DriveTrainCommand();

  private final WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(0);
  private final WPI_TalonSRX m_rearLeft = new WPI_TalonSRX(1);
  private final WPI_TalonSRX m_frontRight = new WPI_TalonSRX(2);
  private final WPI_TalonSRX m_rearRight = new WPI_TalonSRX(3);

  private final SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
  private final SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
  private final DifferentialDrive RobotDrive = new DifferentialDrive(m_left, m_right);

  public DriveTrain() {
  }

  public void arcadeDrive(double x, double y) {
    y = y * 0.6;
    //x = x * -1;//adds y axis
    RobotDrive.arcadeDrive(x, y);
    System.out.println("uninverted");
  }
  public void inverseDrive(double x, double y){
    y = y * 0.6;//x axis
    //x = x * 1;//y axis
    RobotDrive.arcadeDrive(-x, y);
    System.out.println("inverted");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    drive.execute();
    
  }
}
