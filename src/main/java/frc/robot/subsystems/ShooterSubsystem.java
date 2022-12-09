public class ShooterSubsystem extends SubsystemBase 
{
    private WPI_TalonSRX onlyTalon;
    private WPI_VictorSPX onlyVictor;

    public ShooterSubsystem()
    {
        onlyTalon = new WPI_TalonSRX(Ports.CAN_SHOOTER_LEFT_TALONSRX);
        onlyVictor = new WPI_TalonSRX(Ports.CAN_SHOOTER_LEFT_VICTORSRX);

        configureMotors();


    }

    public double getVelocityLeft() {
        return onlyTalon.getSelectedSensorVelocity();
    }

    public void configureMotors()
    {
        onlyTalon.configFactoryDefault();
        onlyVictor.configFactoryDefault();
        

        onlyTalon.setSensorPhase(true);

        onlyTalon.setInverted(true);

        onlyVictor.follow(onlyTalon, MotorConfig.DEFAULT_MOTOR_FOLLOWER_TYPE);

        onlyTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE, MotorConfig.TALON_DEFAULT_PID_ID, MotorConfig.TALON_TIMOUT_MS);

        TalonSRXConfiguration only = new TalonSRXConfiguration();

        only.slot0 = MotionControl.SHOOTER_BOTTOM_PID;

        onlyTalon.configAllSettings(only);
    }

    public void drawRaw(double left) {
        onlyTalon.set(ControlMode.Velocity, left);
    }
    
}
