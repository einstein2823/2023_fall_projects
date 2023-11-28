// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.HoodSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class HoodJoystickCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final HoodSubsystem m_hoodsubsystem;
  private final Joystick m_joystick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public HoodJoystickCommand(HoodSubsystem hoodsubsystem, Joystick joystick) {
    m_hoodsubsystem = hoodsubsystem;
    m_joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(hoodsubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_hoodsubsystem.toohigh()) {
      if (m_joystick.getRawAxis(5) <= 0) {
        m_hoodsubsystem.drive(Math.pow(m_joystick.getRawAxis(5), 3));
      }
    } else if (m_hoodsubsystem.toolow()) {
      if (m_joystick.getRawAxis(5) >= 0) {
        m_hoodsubsystem.drive(Math.pow(m_joystick.getRawAxis(5), 3));
      }
    } else {
      m_hoodsubsystem.drive(Math.pow(m_joystick.getRawAxis(5), 3));
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_hoodsubsystem.drive(0.0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
