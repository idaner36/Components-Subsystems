package frc.robot.subsystems.elevator;

public class Elevator {

    private static Elevator instance;
    private ElevatorComponents components;

    private Elevator(ElevatorComponents components) {
        this.components = components;
    }

    public static void initElevator(ElevatorComponents components) {
        instance = new Elevator(components);
    }

    public static Elevator getInstance() {
        return instance;
    }

    public void setSpeed(double speed) {
        components.getLeftMasterMotor().set(speed);
        components.getRightMasterMotor().set(speed);
    }

    public void stop() {
        setSpeed(0);
    }

    public double getHeading() {
        return components.getGyro().getFusedHeading();
    }

    public void setSpeedByHeading() {
        if (getHeading() > 45)
            setSpeed(0.5);
        else if (getHeading() > 90)
            setSpeed(0.75);
        else if (getHeading() > 180)
            setSpeed(-1);
        else
            stop();
    }
}
