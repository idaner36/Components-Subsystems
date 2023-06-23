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
}
