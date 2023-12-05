// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;

public class TurretSubsystem extends SubsystemBase {

	public final TalonSRX motor = new TalonSRX(23);

	final CommandJoystick m_driverController = new CommandJoystick(OperatorConstants.kDriverControllerPort);

	NetworkTable table = NetworkTableInstance.getDefault().getTable("TurretSubsystem");

	public double kTurretSpeed = Constants.kTurretSpeed;
	
	

	/** Creates a new TurretSubsystem. */
	public TurretSubsystem() {
		table.putValue("TurretSpeed", NetworkTableValue.makeDouble(kTurretSpeed));
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
		
		kTurretSpeed = table.getEntry("motorSpeed").getDouble(0.0);
	}

	@Override
	public void simulationPeriodic() {
		// This method will be called once per scheduler run during simulation
	}
}
