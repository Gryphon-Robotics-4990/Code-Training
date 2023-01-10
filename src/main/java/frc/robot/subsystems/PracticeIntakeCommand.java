public class IntakeCommand {
    
    private final PracticeIntakeSubsystem m_intake;

    public void initialize() {
        m_intake.extend();
    }

    public void execute() {
        m_intake.setSpeed(.5);
    }

    public void end() {
         m_intake.retract();
         m_intake.setSpeed(0);
    }
}