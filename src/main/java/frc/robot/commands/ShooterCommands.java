 public class PracticeShooterCommand{
     private PracticeShooterSubsystem shootertrain;

     public PracticeShooter(PracticeShooterSubsystem inputShootertrain){
         shootertrain = inputShootertrain;
         addrequirements(inputShootertrain);
     }
 }

@Override
public void execute(){
    PracticeShooter.shoot(0.5));
}