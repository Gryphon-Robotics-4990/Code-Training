public class AutoCommand extends SequentialCommandGroup {
    
    private final PracticeTurretSubsystem m_turret;

    public AutoCommand(PracticeTurretSubsystem turret, PracticeDrivetrainSubsystem drive) {
        addCommands(
        new ParallelRaceGroup(
            new WaitCommand(2), 
            new PracticeDriveBackwardsCommand(drive)
        ),

        new InstantCommand(() -> m_turret.setPosition(1024))
    )
    }
    
}