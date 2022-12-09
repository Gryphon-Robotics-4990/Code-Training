package frc.robot.commands;
import frc.robot.Constants.*;
import frc.robot.subsystems.PracticeTurretSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PracticeTurretCommand extends CommandBase 
{
    private PracticeTurretSubsystem turret;
    private DoubleSupplier supplier;

    public PracticeTurretCommand(PracticeTurretSubsystem inputTurret)
    {
        turret = inputTurret;
        addrequirements(inputTurret);
    }

    public void setSupplier(DoubleSupplier inputSupplier)
    {
        supplier = inputSupplier;
    }

    @Override
    public void execute()
    {
        turret.setPosition(supplier.getAsDouble()*4096);
    }
}