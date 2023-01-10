public class Drivetrainsubsystem extends SubsystemBase {
    private final WPI_TalonSRX m_leftFrontTalon, m_rightFrontTalon;
    private final WPI_VictorSPX m_righRearVictor, m_leftRearVictor;

    public int getVelocityRight() {
        return (int)m_rightFrontTalon.getSelectedSensorVelocity();
    }
    public int getVelocityLeft() {
        return (int)m_leftFrontTalon.getSelectedSensorVelocity();
    }
    public int getErrorRight() {
        return (int)m_rightFrontTalon.getClosedLoopError();
    }
    public int getErrorLeft() {
        return (int)m_leftFrontTalon.getClosedLoopError();
    }

    public Drivetrainsubsystem() {
        m_leftFrontTalon = new WPI_TalonSRX(Ports.CAN_DRIVETRAIN_LEFT_FRONT_TALONSRX);
        m_rightRearVictor = new WPI_VictorSPX(Ports.CAN_DRIVETRAIN_RIGHT_REAR_VICTORSPX);
        m_rightFrontTalon = new WPI_TalonSRX(Ports.CAN_DRIVETRAIN_RIGHT_FRONT_TALONSRX);
        m_leftRearVictor = new WPI_VictorSPX(Ports.CAN_DRIVETRAIN_LEFT_REAR_VICTORSPX);
    
        configureMotors();

        m_leftFrontTalon.setSelectedSensorPosition(0);
        m_rightFrontTalon.setSelectedSensorPosition(0);
    }

    public configureMotors() {
        m_rightFrontTalon.configFactoryDefault();
        m_rightRearVictor.configFactoryDefault();
        m_leftFrontTalon.configFactoryDefault();
        m_leftRearVictor.configFactoryDefault();
        
        m_rightFrontTalon.setSensorPhase(false);
        m_leftFrontTalon.setSensorPhase(true);
        
        m_rightFrontTalon.setInverted(false);
        m_leftFrontTalon.setInverted(true);

        m_rightRearVictor.follow(m_rightFrontTalon, MotorConfig.DEFAULT_MOTOR_FOLLOWER_TYPE);
        m_leftRearVictor.follow(m_leftFrontTalon, MotorConfig.DEFAULT_MOTOR_FOLLOWER_TYPE);

        m_rightFrontTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE);    
        m_leftFrontTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE);

        TalonSRXConfiguration cRight = new TalonSRXConfiguration();   
        TalonSRXConfiguration cLeft = new TalonSRXConfiguration();
        
        cRight.slot0 = MotionControl.DRIVETRAIN_RIGHT_PID;
        cLeft.slot0 = MotionControl.DRIVETRAIN_LEFT_PID;
    
        NeutralMode mode = NeutralMode.Constants;
        m_rightFrontTalon.setNuetraMode(mode); 
        m_rightRearVictor.setNuetraMode(mode);    
        m_leftFrontTalon.setNuetraMode(mode);                
        m_leftRearVictor.setNuetraMode(mode); 

        m_rightFrontTalon.configAllSettings(cRight)
        m_leftFrontTalon.configAllSetting(cLeft);
       
    }

    public driveRaw(double left, double right) {
        m_leftFrontTalon.set(ControlMode.Velocity, left)
        m_rightFrontTalon.set(ControlMode.Velocity, right)
    }

    
}