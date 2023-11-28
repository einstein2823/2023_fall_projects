// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OperatorConstants;

public class TurretSubsystem extends SubsystemBase {

	public final TalonSRX motor = new TalonSRX(23);

	final Joystick m_driverController = new Joystick(OperatorConstants.kDriverControllerPort);
	public JoystickButton button0 = new JoystickButton(m_driverController, 0);
	public JoystickButton button1 = new JoystickButton(m_driverController, 1);

	/** Creates a new TurretSubsystem. */
	public TurretSubsystem() {
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
	 * An example method querying a boolean state of the subsystem (for example, a
	 * digital sensor).
	 *
	 * @return value of some boolean subsystem state, such as a digital sensor.
	 */
	public boolean exampleCondition() {
		// Query some boolean state, such as a digital sensor.
		return false;
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}

	@Override
	public void simulationPeriodic() {
		// This method will be called once per scheduler run during simulation
	}
}
