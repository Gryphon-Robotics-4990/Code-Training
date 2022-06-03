package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.PracticeDrivetrainSubsystem;
import frc.robot.subsystems.PracticeTurretSubsystem;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PracticeAutoCommand extends SequentialCommandGroup
{
    private PracticeDrivetrainSubsystem drivetrain;
    private PracticeTurretSubsystem turret;

    public AutoCommand(PracticeDrivetrainSubsystem inputDrivetrain, PracticeTurretSubsystem inputTurret)
    {
        drivetrain = inputDrivetrain;
        turret = inputTurret;

        addCommands(
            new ParallelRaceGroup(
                new WaitCommand(2),
                new PracticeAutoDrivetrainCommand(drivetrain, 0.5)
            ),
            new PracticeTurretPositionCommand(turret, 1024)
        );
    }
}