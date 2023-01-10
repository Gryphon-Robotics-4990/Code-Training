public class IntakeSubsystem {
    public IntakeSubsystem() {
        m_intakeRight = new WPI_TalonSRX
        m_breakbeam = new DigitalInput(Ports.DIO_BREAKBEAM)

        m_compressor = new Compressor(Ports.CAN_PCM, PneumaticsModuleType.CTREPCM);
        m_compressor.enableDigital();
        m_solenoid = new Solenoid(Ports.CAN_PCM, PneumaticsModuleType.CTREPCM, Ports.SOLENOID_PORT);
        configureMotors();
    }

    public void configureMotors() {
        m_intakeTalon.configFactoryDefault();
    }

    public void setSpeed(double speed) {
        m_intakeRight.set(ControlMode.PercentOutput, speed);
    }

    public boolean hasBall() {
        return !m_breakbeam.get();
    }

    public boolean isExtended() {
        return m_solenoid.get();
    }

    public void extend() {
        m_solenoid.set(true)
    }

    public void retract() {
        m_solenoid.set(false)
    }

    public void stoCompressor() {
        m_compressor.disable();
    }
}