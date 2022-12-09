package frc.robot.subsystems;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public PracticeTurretSubsystem extends SubsystemBase
{
    private WPI_TalonSRX talon;

    public PracticeTurretSubsystem()
    {
        talon = new WPI_TalonSRX(Ports.CAN_TURRET_TALONSRX);

        this.configureMotors();
        
        talon.setSelectedSensorPosition(0);
    }

    public void setPosition(double position)
    {
        talon.set(ControlMode.Position, position);
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
        return talon.getClosedLoopTarget();
    }

    public void configureMotors()
    {
        talon.configFactoryDefault();

        talon.setSensorPhase(false);

        talon.setInverted(false);

        talon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE, MotorConfig.TALON_DEFAULT_PID_ID, MotorConfig.TALON_TIMEOUT_MS);

        TalonSRXConfiguration t = new TalonSRXConfiguration();

        t.slot0 = MotionControl.TURRET_PID;

        talon.setNeutralMode(NeutralMode.Brake);

        talon.configAllSettings(t);
    }
}