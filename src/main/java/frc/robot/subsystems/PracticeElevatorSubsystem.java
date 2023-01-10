public class PracticeElevatorSubsystem {    
    public ElevatorSubsystem() {
        m_leftTalon = new WPI_TalonSRX(Ports.CAN_ELEVATOR_LEFT_TALONSRX);
        m_rightTalon = new WPI_TalonSPX(Ports.CAN_ELEVATOR_RIGHT_TALONSRX);
        extended = 100000000
        configureMotors();  
    }

    public configureMotors() {
        m_leftTalon.configFactoryDefault();
        m_rightTalon.configFactoryDefault();
        
        m_leftTalon.setSensorPhase(false);
        m_rightTalon.setSensorPhase(true);

        m_rightTalon.follow(m_leftTalon, MotorConfig.DEFAULT_MOTOR_FOLLOWER_TYPE);

        m_rightTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE));    
        m_leftTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE));    

        TalonSRXConfiguration c_left = new TalonSRXConfiguration();   
        TalonSRXConfiguration c_right = new TalonSRXConfiguration();   
        
        c_left.slot0 = MotionControl.Elevator_PID;
        c_right.slot0 = MotionControl.Elevator_PID;
        
        m_leftTalon.configAllSettings(c_left)
        m_rightTalon.configAllSettings(c_right)
    }

    public void setPosition(double position) {
        m_leftTalon.set(ControlMode.Position, position);
    }
   
    public double getPosition() {
        return m_leftTalon.getSelectedSensorPosition();
    }

    public boolean isExtended() {
        return getPosition() == extended;
    }

}