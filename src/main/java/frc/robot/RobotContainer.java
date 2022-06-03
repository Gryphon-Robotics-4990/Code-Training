package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.vision.VisionController;
import frc.robot.JoystickF310.*;
import frc.robot.JoystickLeonardo.ButtonLeonardo;

import static frc.robot.Constants.*;

public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    
    private final JoystickF310 joystickDrive = new JoystickF310(Ports.PORT_JOYSTICK_DRIVE);
    private final JoystickF310 joystickOperator = new JoystickF310(Ports.PORT_JOYSTICK_OPERATOR);
    private final JoystickLeonardo joystickLeonardo = new JoystickLeonardo(1);


    // Create subsystems
    private final PracticeDrivetrainSubsystem drivetrain = new PracticeDrivetrainSubsystem();
    private final PracticeElevatorSubsystem elevator = new PracticeElevatorSubsystem();
    private final PracticeIntakeSubsystem intake = new PracticeIntakeSubsystem();
    private final PracticeTurretSubsystem turret = new PracticeTurretSubsystem();
    //Create Commands
    private final PracticeAutoCommand m_practiceAutoCommand = new PracticeAutoCommand(drivetrain, turret);
    private final PracticeDrivetrainCommand m_practiceDrivetrainCommand = new PracticeDrivetrainCommand(drivetrain);
    private final PracticeElevatorCommand m_practiceElevatorCommand = new PracticeElevatorCommand(elevator);
    private final PracticeIntakeCommand m_practiceIntakeCommand = new PracticeIntakeCommand(intake);
    private final PracticeTurretCommand m_practiceTurretCommand = new PracticeTurretCommand(turret);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        // Configure all the control bindings
        configureControlBindings();
        //VisionController.ShooterVision.setControlPoints(Vision.CONTROL_POINTS);
    }

    private void configureControlBindings() {
        //Suppliers:
        m_practiceDrivetrainCommand.setSuppliers(
            () -> DriveUtil.powCopySign(joystickDrive.getRawAxis(AxisF310.JoystickLeftY), JOYSTICK_THROTTLE_EXPONENT),
            () -> DriveUtil.powCopySign(joystickDrive.getRawAxis(AxisF310.JoystickRightX), JOYSTICK_TURNING_EXPONENT)

        );

        m_practiceTurretCommand.setSupplier(() -> DriveUtil.powCopySign(-joystickOperator.getRawAxis(AxisF310.JoystickLeftX), JOYSTICK_OPERATOR_EXPONENT));

        joystickOperator.getButton(ButtonF310.A).togglewhenPressed(m_practiceIntakeCommand);

        joystickOperator.getButton(ButtonF310.Y).whenPressed(m_practiceElevatorCommand);
    }

    public void setTeleopDefaultCommands() {
        //Put default command setters here once auto works
        //Default Commands;
        CommandScheduler.getInstance().setDefaultCommand(drivetrain, m_practiceDrivetrainCommand);
        //CommandScheduler.getInstance().setDefaultCommand(m_turret, m_limelightTurretAimCommand);
    }

    public Command getAutonomousCommand() {
        // Moving backwards and shooting the ball we start with
        //return m_autoCommand;
        // Two ball auto:
        return m_practiceAutoCommand;
    }
}