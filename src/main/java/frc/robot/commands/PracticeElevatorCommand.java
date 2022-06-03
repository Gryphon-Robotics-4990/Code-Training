package frc.robot.commands;
import frc.robot.Constants.*;
import frc.robot.subsystems.PracticeElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

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