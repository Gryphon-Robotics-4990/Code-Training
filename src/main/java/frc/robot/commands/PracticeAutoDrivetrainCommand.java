package frc.robot.commands;
import frc.robot.Constants.*;
import frc.robot.subsystems.PracticeDrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PracticeAutoDrivetrainCommand extends CommandBase 
{
    private PracticeAutoDrivetrainCommand drivetrain;
    private double percentOutput;

    public PracticeDrivetrainCommand(PracticeDrivetrainSubsystem inputDrivetrain, double output);
    {
        turret = inputDrivetrain;
        percentOutput = output;
        addrequirements(inputDrivetrain);
    }

    @Override
    public void execute()
    {
        drivetrain.drive(SubsystemConfig.DRIVETRAIN_MAXIMUM_TESTED_ENCODER_VELOCITY*percentOutput, SubsystemConfig.DRIVETRAIN_MAXIMUM_TESTED_ENCODER_VELOCITY*percentOutput);
    }
}