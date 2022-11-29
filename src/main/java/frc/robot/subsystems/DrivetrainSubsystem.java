public class DrivetrainSubsystem{
    m_leftTalon = new WPI_TalonSRX(Ports.CAN_DRIVE_LEFT_TALONSRX);
    m_leftVictor = new WPI_VictorSRX(Ports.CAN_DRIVE_LEFT_VICTORSRX);

    configmotors();

    private void configmotorsdrive{
        set.leftTalon (inverted);
        set.leftVictor (inverted)
    }

}

    

}