public class driveCommand extends CommandBase {

    private final PracticeDrivetrainsubsystem m_drivetrain;
    private DoubleSupplier m_speedSupplier, m_rotationSupplier;

    public driveCommand(PracticeDrivetrainsubsystem drivetrain) {
        m_drivetrain = drivetrain;
        addRequirments(drivetrain)
    }

    public void execute() {
        double[] speeds = DriveUtil.arcadeToTankDrive(m_speedSupplier.getAsDouble() * ARCADE_SPEED_MULTIPLIER, m_rotationSupplier.getAsDouble() * ARCADE_ROTATION_MULTIPLIER)

        speeds[0] *= SubsystemConfig.DRIVETRAIN_MAXIMUM_TESTED_ENCODER_VELOCITY;
        speeds[1] *= SubsystemConfig.DRIVETRAIN_MAXIMUM_TESTED_ENCODER_VELOCITY;
    
        m_drivetrain.driveRaw(speeds[0] * -1, speeds[1] * -1);
    }
}