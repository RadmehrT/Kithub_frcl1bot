// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    VictorSPX motor1 = new VictorSPX(0);
    VictorSPX motor2 = new VictorSPX(1);
    VictorSPX motor3 = new VictorSPX(3);
    VictorSPX motor4 = new VictorSPX(4);
    // Configure the trigger bindings
    configureBindings();

    XboxController controller = new XboxController(0);
    double Lstick_val = controller.getRawAxis(0);
    if (Lstick_val == 0) {
      motor1.set(ControlMode.PercentOutput, 0.5);
      motor2.set(ControlMode.PercentOutput, 0.5);
      motor3.set(ControlMode.PercentOutput, 0.5);
      motor4.set(ControlMode.PercentOutput, 0.5);

      System.out.println(motor1.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor1.getBusVoltage());
      System.out.println(motor2.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor2.getBusVoltage());
      System.out.println(motor3.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor3.getBusVoltage());
      System.out.println(motor4.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor4.getBusVoltage());
    } else if (Lstick_val == -1) {
      motor1.set(ControlMode.PercentOutput, 0.0);
      motor2.set(ControlMode.PercentOutput, 0.0);
      motor3.set(ControlMode.PercentOutput, 0.0);
      motor4.set(ControlMode.PercentOutput, 0.0);

      System.out.println(motor1.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor1.getBusVoltage());
      System.out.println(motor2.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor2.getBusVoltage());
      System.out.println(motor3.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor3.getBusVoltage());
      System.out.println(motor4.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor4.getBusVoltage());
    } else if (Lstick_val == 90) {
      motor1.set(ControlMode.PercentOutput, 1.0);
      motor2.set(ControlMode.PercentOutput, 1.0);
      motor3.set(ControlMode.PercentOutput, 0.0);
      motor4.set(ControlMode.PercentOutput, 0.0);

      System.out.println(motor1.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor1.getBusVoltage());
      System.out.println(motor2.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor2.getBusVoltage());
      System.out.println(motor3.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor3.getBusVoltage());
      System.out.println(motor4.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor4.getBusVoltage());
    } else if (Lstick_val == 270) {
      motor1.set(ControlMode.PercentOutput, 0.0);
      motor2.set(ControlMode.PercentOutput, 0.0);
      motor3.set(ControlMode.PercentOutput, 1.0);
      motor4.set(ControlMode.PercentOutput, 1.0);

      System.out.println(motor1.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor1.getBusVoltage());
      System.out.println(motor2.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor2.getBusVoltage());
      System.out.println(motor3.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor3.getBusVoltage());
      System.out.println(motor4.getMotorOutputPercent()); // prints the percent output of the motor (0.5)
      System.out.println(motor4.getBusVoltage());
    }

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is
    // pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
