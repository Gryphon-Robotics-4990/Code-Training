public PracticeElevatorSubsystem{
    private WPI_TalonSRX talon;

    private WPI_VictorSRX victor;
    public PracticeElevatorSubsystem(){
        talon = new WPI_TalonSRX(Ports.CAN_ELEVATOR_TALONSRX);
        //*
    
        this.configureMotors();

        talon.setSelectedSensorPosition(0);
    }
    public void setPosition(double position){
        talon.set(ControlMode.Position, position);
    }

    public boolean isInPosition(){
        return Math.abs(talon.getClosedLoopError()) < SubsystemConfig.
    }
    public boolean hasReachedMax(){
        return talon.getSelectedSensorPosition() < 10000
    }
    public boolean currentPosition(){
        return talon.getSelectedSensorPosition();
    }

    public void ConfigMotors(){
        talon.setSensorPhase(false);
        talon.setInverted(true);

        leftVictor.follow(leftTalon, MotorConfig.DEFAULT_MOTOR_FOLLOWER_TYPE; 
    }

}