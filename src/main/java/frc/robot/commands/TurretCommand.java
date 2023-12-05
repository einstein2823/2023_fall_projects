// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TurretSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurretCommand extends CommandBase {
  

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TurretSubsystem m_subsystem;

  int m_direction;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TurretCommand(TurretSubsystem subsystem, int direction) {
    m_subsystem = subsystem;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    m_direction = direction;
    
  }

  NetworkTable table = NetworkTableInstance.getDefault().getTable("TurretSubsystem");
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_direction == 1) {
      m_subsystem.motor.set(ControlMode.PercentOutput, m_subsystem.kTurretSpeed);
    }
    else if (m_direction == -1) {
      m_subsystem.motor.set(ControlMode.PercentOutput, m_subsystem.kTurretSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.motor.set(ControlMode.PercentOutput, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
