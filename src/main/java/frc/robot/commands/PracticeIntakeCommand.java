package frc.robot.subsystems;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

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