//chiara

package frc.robot.subsystem;
import frc.roboto.Constants.*;

public class ShooterSubsystem(){
    private WPI_TalonSRX leftTalon;
    private WPI_TalonSRX leftVictor;

    this.configureMotors();
//returning error
    public double getError(){
        return leftTalon.getClosedLoopError();
    }
    public double getVelocity(){
        return leftTalon.getSelectedSensorVelocity();
    }


    public void configureMotors(){
        //inverted 
        leftTalon.setInverted(true);

        //follow
        leftVictor.follow(leftTalon, MotorConfig.DEFAULT_MOTOR_FOLLOWER_TYPE; 

        leftTalon.configSelectedFeedbackSensor(MotorConfig.TALON_DEFAULT_FEEDBACK_DEVICE, MotorConfig.TALON_DEFAULT_PID_ID, MotorConfig.TALONG_TIMEOUT_MS);
        TalonSRXConfiguration left = new TalonSRXConfiguration();

        left.slot0 = MotionControl.SHOOTER_PID;
        leftTalon.configAllSettings(left);

    }
    public void shoot(double shooterspeed){
        leftTalon.set(ControlModel.Velocity, shooterspeed);
    }

    
}