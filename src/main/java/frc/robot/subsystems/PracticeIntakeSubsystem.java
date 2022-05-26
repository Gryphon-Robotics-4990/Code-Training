package frc.robot.subsystems;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public PracticeIntakeSubsystem extends SubsystemBase
{
    private WPI_TalonSRX talon;
    private DigitalInput breakbeam;
    private Compressor compressor;
    private Solenoid solenoid;

    public PracticeIntakeSubsystem()
    {
        talon = new WPI_TalonSRX(Ports.CAN_INTAKE_RIGHT_TALONSRX);
        breakbeam = new DigitalInput(Ports.DIO_BREAKBEAM);
        compressor = new Compressor(Ports.CAN_PCM, PneumaticsModuleType.CTREPCM);
        compressor.enableDigital();
        solenoid = new Solenoid(Ports.CAN_PCM, PneumaticsModuleType.CTREPCM), Ports.SOLENOID_PORT);

        configureMotors();
    }

    public void setSpeed(double speed)
    {
        talon.set(ControlMode.PercentOutput, speed);
    }

    public void extend()
    {
        solenoid.set(true);
    }

    public void retract()
    {
        solenoid.set(false);
    }

    public void stop()
    {
        compressor.disable();
    }

    public boolean hasBall()
    {
        return !breakbeam.get();
    }

    public boolean getPosition()
    {
        return solenoid.get();
    }

    public void configureMotors()
    {
        talon.configFactoryDefault();

        talon.setSensorPhase(true);

        talon.setInverted(false);

        talon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE, MotorConfig.TALON_DEFAULT_PID_ID, MotorConfig.TALON_TIMEOUT_MS);

        talon.setNeutralMode(NeutralMode.Brake);

        talon.configAllSettings();
    }
}