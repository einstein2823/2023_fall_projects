// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HoodSubsystem extends SubsystemBase {
  TalonSRX motor = new TalonSRX(23);
  Joystick exampleJoystick = new Joystick(0);

  /** Creates a new ExampleSubsystem. */
  public HoodSubsystem() {
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    motor.getSelectedSensorPosition();
    // This method will be called once per scheduler run
  }

  public boolean toohigh() {
    if (Constants.hoodmin >= motor.getSelectedSensorPosition()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean toolow() {
    if (Constants.hoodmax <= motor.getSelectedSensorPosition()) {
      return true;
    } else {
      return false;
    }
  }

  public void drive(double speed) {
    motor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
