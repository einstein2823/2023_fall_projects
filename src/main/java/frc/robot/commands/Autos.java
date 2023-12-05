// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.HoodSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static CommandBase exampleAuto(HoodSubsystem subsystem, Joystick joystick) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new HoodJoystickCommand(subsystem, joystick));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
