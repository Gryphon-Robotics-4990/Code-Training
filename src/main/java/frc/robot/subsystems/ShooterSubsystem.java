public class ShooterSubsystem extends SubsystemBase
{    
    private WPI_VictorSRX leftVictor; 
    private WPT_TalonSRX rightTalon; 
    
    public PracticeShooterSubsystem()
    {
        leftVictor = new WPI_VictorSRX(Ports.CAN_SHOOTER_LEFT_VICTORSRX);
        rightTalon = new WPI_TalonSRX(Ports.CAN_SHOOTER_RIGHT_TALONSRX);

        this.configureMotors

        leftVictor.setSelectedSensorPosition(0); 
        rightTalon.setSelectedSensorPosition(0); 
    }

    public double getVelocityRight() {
        return leftVictor.getSelectedSensorVelocity(); 
    }

    public double getVelocityLeft() {
        return rightVictor.getSelectedSensorVelocity(); 
    }

    public void configureMotors()
    {
    leftVictor.configFactoryDefault(); 
    rightTalon.configFactoryDefault(); 

    leftVictor.setInverted(True); 
    rightTalon.setInverted(False); 

    leftVictor.follow(rightTalon, MotorConfig.DEFAULT_MOTOR_FOLLOWER_TYPE); 

    rightTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE, MotorConfig.TALON_DEFAULT_PID_ID, MotorConfig.TALON_TIMEOUT_MS);
    }

    TalonSRXConfiguration left = new TalonSRXConfiguration 

    public void shoot(double leftVelocity, double rightVelocity)
    {
        rightTalon.set(ControlMode.Velocity, rightVelocity); 
    }
}