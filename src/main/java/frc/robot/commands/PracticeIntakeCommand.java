package frc.robot.commands;
import frc.robot.Constants.*;
import frc.robot.subsystems.PracticeIntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PracticeIntakeCommand extends CommandBase 
{
    private PracticeIntakeSubsystem intake;
    private DoubleSupplier supplier;

    public PracticeIntakeCommand(PracticeIntakeSubsystem inputIntake)
    {
        intake = inputIntake;
        addrequirements(inputIntake);
    }

    @Override
    public void initialize()
    {
        intake.extend();
    }

    @Override
    public void execute(double speed)
    {
        intake.setSpeed(speed);
    }

    @Override
    public void end()
    {
        intake.retract()
        intake.setSpeed(0.0);
    }
}