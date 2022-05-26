package frc.robot.subsystems;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class PracticeElevatorCommand extends CommandBase 
{
    private PracticeElevatorSubsystem elevator;
    private DoubleSupplier supplier;

    public PracticeElevatorCommand(PracticeElevatorSubsystem inputElevator)
    {
        elevator = inputElevator;
        addrequirements(inputElevator);
    }

    @Override
    public void initialize()
    {
        elevator.setPosition(SubsystemConfig.ELEVATOR_MAXIMUM_ALLOWED_ERROR);
        //I know ELEVATOR_MAXIMUM_ALLOWED_ERROR is doesn't exist
    }

    @Override
    public void isFinished()
    {
        return elevator.isInPosition();
    }

    @Override
    public void end()
    {
        System.out.println(elevator.currentPosition());
    }
}