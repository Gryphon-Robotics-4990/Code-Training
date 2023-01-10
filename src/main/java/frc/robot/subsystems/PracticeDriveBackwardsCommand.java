public class DriveBackwardsCommand extends CommandBase {
    private final Drivetrainsubsystem m_drivetrain;

    public DriveBackwardsCommand(DrivetrainSubsystem drive) {
        m_drivetrain = drive
        addRequirements(drive)
    }

    public execute() {
        factor = -.5
        speed = factor*SubsystemConfig.DRIVETRAIN_MAXIMUM_TESTED_ENCODER_VELOCITY;

        m_drivetrain.driveRaw(speed, speed))
    }
}