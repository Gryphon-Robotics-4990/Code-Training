package frc.robot.subsystems;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class PracticeTurretCommand extends CommandBase 
{
    private PracticeTurretCommand turret;
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