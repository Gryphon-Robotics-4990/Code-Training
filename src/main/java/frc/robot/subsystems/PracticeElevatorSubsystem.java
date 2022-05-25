package frc.robot.subsystems;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public PracticeElevatorSubsystem extends SubsystemBase
{
    private WPI_TalonSRX talon1, talon2;

    public PracticeTurretSubsystem()
    {
        talon = new WPI_TalonSRX(CAN_TURRET_TALONSRX);
        desired = 0.0;

        configureMotors();
        
        talon.setSelectedSensorPosition(0);
    }

    public void setPosition(double position)
    {
        talon.set(ControlMode.position, position);
        desired = position;
    }

    public boolean isInPosition()
    {
        return Math.abs(talon.getClosedLoopError()) < SubsystemConfig.TURRET_MAXIMUM_ALLOWED_ERROR;
    }

    public double currentPosition()
    {
        return talon.getSelectedSensorPosition();
    }

    public double desiredPosition()
    {
        return desired;
    }
}