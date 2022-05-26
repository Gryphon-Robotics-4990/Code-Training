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

    public PracticeElevatorSubsystem()
    {
        talon = new WPI_TalonSRX(Ports.CAN_ELEVATOR_TALONSRX);
        //I know there's no port for elevator

        configureMotors();
        
        talon1.setSelectedSensorPosition(0);
    }

    public void setPosition(double position)
    {
        talon1.set(ControlMode.position, position);
    }

    public boolean isInPosition()
    {
        return Math.abs(talon1.getClosedLoopError()) < SubsystemConfig.ELEVATOR_MAXIMUM_ALLOWED_ERROR;
        //Yes, I know ELEVATOR_MAXIMUM_ALLOWED_ERROR is nonexistent
    }

    public double currentPosition()
    {
        return talon1.getSelectedSensorPosition();
    }

    public void configureMotors()
    {
        talon1.configFactoryDefault();
        talon2.configFactoryDefault();

        talon1.setSensorPhase(true);

        talon1.setInverted(false);
        
        talon2.follow(talon1, MotorConfig.DEFAULT_MOTOR_FOLLOWER_TYPE);

        talon1.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE, MotorConfig.TALON_DEFAULT_PID_ID, MotorConfig.TALON_TIMEOUT_MS);

        TalonSRXConfiguration config = new TalonSRXConfiguration();

        config.slot0 = MotionControl.ELEVATOR_PID;
        //Yes, I know ELEVATOR_PID doesn't exist

        NeutralMode neutralMode = NeutralMode.Coast;

        talon1.setNeutralMode(neutralMode);
        talon2.setNeutralMode(neutralMode);

        talon1.configAllSettings(config);
    }
}