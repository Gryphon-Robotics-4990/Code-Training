public class PraticeTurretCommand {
    private final PracticeTurreSubsystem m_turret;

    public TurretCommand(PracticeTurretSubsytem turret) {
        m_turret = turret
        addRequirements()
    }

    public LimelightTurretAimCommand(TurretSubsystem turret) {
        m_turret = turret
        addRequirments(turret)
    }

    public void execute() {
        double currentPos = m_turret.getEncoderPosition();
        double change = m_rotationSupplier.getAsDouble();
        m_turret.setPosition(currentPos + change*4096);
    }

    public void setSuppliers(DoubleSupplier rotationSupplier) {
        m_rotationSupplier = rotationSupplier;
    } 
}