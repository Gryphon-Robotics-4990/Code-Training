package src.main.java.frc.robot.commands;
import frc.robot.Constants.*;
import frc.robot.DriveUtil;
import frc.robot.subsystems.PracticeDrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PracticeDrivetrainCommand extends CommandBase
{
    private PracticeDrivetrainSubsystem drivetrain;
    private DoubleSupplier speedSupplier, rotationSupplier;

    public PracticeDrivetrainCommand(PracticeDrivetrainSubsystem inputDrivetrain)
    {
        drivetrain = inputDrivetrain;
        addRequirements(inputDrivetrain);
    }

    public void setSuppliers(DoubleSupplier inputSpeed, DoubleSupplier inputDrivetrain)
    {
        speedSupplier = inputSpeed;
        rotationSupplier = inputRotation;
    }

    @Override
    public void execute()
    {
        double[] speeds = DriveUtil.arcadeToTankDrive(speedSupplier.getAsDouble() * ARCADE_SPEED_MULTIPLIER, rotationSupplier.getAsDouble() * ARCADE_ROTATION_MULTIPLIER);

        speeds[0] *= SubsystemConfig.DRIVETRAIN_MAXIMUM_TESTED_ENCODER_VELOCITY;
        speeds[1] *= SubsystemConfig.DRIVETRAIN_MAXIMUM_TESTED_ENCODER_VELOCITY;

        drivetrain.drive(speeds[0]*0.4, speeds[1]*0.4);
    }
}