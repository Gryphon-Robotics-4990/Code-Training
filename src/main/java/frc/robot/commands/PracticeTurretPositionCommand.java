package frc.robot.commands;
import frc.robot.Constants.*;
import frc.robot.subsystems.PracticeTurretSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PracticeTurretPositionCommand extends CommandBase
{
    private PracticeTurretSubsystem turret;
    private double position;

    public PracticeTurretPositionCommand(PracticeTurretSubsystem inputTurret, double inputPosition)
    {
        turret = inputTurret;
        position = inputPosition;
        addrequirements(inputTurret);
    }

    @Override
    public void execute()
    {
        turret.setPosition(position);
    }
}