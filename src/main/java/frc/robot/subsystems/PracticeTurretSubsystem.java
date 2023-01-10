public class PracticeTurretSubsystem {
    public TurretSubsystem() {
        m_turrentTalon = new WPI_TalonSRX(Ports.CAN_TURRET_TALONSRX);
        
        configureMotors();
        m_turrentTalon.setSelectedSensorPosition(0);    
    }

    public configureMotors() {
        m_turrentTalon.configFactoryDefault();
        
        m_turrentTalon.setSensorPhase(false);
        m_turrentTalon.setInverted(false);

        m_turrentTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE, MotorConfig.TALON_DEFAULT_PID_ID, MotorConfig.TALON_TIMEOUT_MS));    

        TalonSRXConfiguration c = new TalonSRXConfiguration();   
        
        c.slot0 = MotionControl.TURRET_PID;
      
        m_FrontTalon.configAllSettings(c)
    }

    public void setPosition(double position) {
        m_turretTalon.set(ControlMode.Position, position);
    }
   
    public double getPosition() {
        return m_turretTalon.getSelectedSensorPosition();
    }

    public double getDesiredPosition() {
        m_turretTalon.getClosedLoopTarget();
    }

    public boolean isReady() {
        return Math.abs(m_turrentTalon.getClosedLoopError()) < SubsystemConfig.TURRET_MAXIMUM_ALLOWED_ERROR;
    }

}