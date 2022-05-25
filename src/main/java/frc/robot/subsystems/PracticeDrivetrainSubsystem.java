package frc.robot.subsystems;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class PracticeDrivetrainSubsystem extends SubsystemBase
{
    private WPI_TalonSRX leftTalon, rightTalon;
    private WPI_VictorSPX leftVictor, rightVictor;
    
    public PracticeDrivetrainSubsystem()
    {
        leftTalon = new WPI_TalonSRX(Ports.CAN_DRIVETRAIN_LEFT_FRONT_TALONSRX);
        rightTalon = new WPI_TalonSRX(Ports.CAN_DRIVETRAIN_RIGHT_FRONT_TALONSRX);
        leftVictor = new WPI_VictorSPX(Ports.CAN_DRIVETRAIN_LEFT_REAR_TALONSRX);
        rightVictor = new WPI_VictorSPX(Ports.CAN_DRIVETRAIN_RIGHT_REAR_TALONSRX);

        configureMotors();

        leftTalon.setSelectedSensorPosition(0);
        rightTalon.setSelectedSensorPosition(0);
    }

    public int getVelocityRight() {
        return (int)m_rightFrontTalon.getSelectedSensorVelocity();
    }

    public int getVelocityLeft() {
        return (int)m_leftFrontTalon.getSelectedSensorVelocity();
    }

    public int getErrorLeft() {
        return (int)m_leftFrontTalon.getClosedLoopError();
    }

    public int getErrorRight() {
        return (int)m_rightFrontTalon.getClosedLoopError();
    }
    
    public void configureMotors()
    {
        leftTalon.configFactoryDefault();
        rightTalon.configFactoryDefault();
        leftVictor.configFactoryDefault();
        rightVictor.configFactoryDefault();

        leftTalon.setSensorPhase(true);
        rightTalon.setSensorPhase(false);

        leftTalon.setInverted(true);
        leftVictor.setInverted(true);
        
        leftVictor.follow(leftTalon);
        rightVictor.follow(rightTalon);

        leftTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE, MotorConfig.TALON_DEFAULT_PID_ID, MotorConfig.TALON_TIMEOUT_MS);
        rightTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE, MotorConfig.TALON_DEFAULT_PID_ID, MotorConfig.TALON_TIMEOUT_MS);

        TalonSRXConfiguration left = new TalonSRXConfiguration(), right = new TalonSRXConfiguration();

        left.slot0 = MotionControl.DRIVETRAIN_LEFT_PID;
        right.slot0 = MotionControl.DRIVETRAIN_RIGHT_PID;

        NeutralMode neutralMode = NeutralMode.Coast;

        leftTalon.setNeutralMode(neutralMode);
        rightTalon.setNeutralMode(neutralMode);
        leftVictor.setNeutralMode(neutralMode);
        rightVictor.setNeutralMode(neutralMode);

        leftTalon.configAllSettings(left);
        rightTalon.configAllSettings(right);
    }

    public void drive(double leftVelocity, double rightVelocity)
    {
        leftTalon.set(ControlMode.Velocity, leftVelocity);
        rightTalon.set(ControlMode.Velocity, rightVelocity);
    }
}