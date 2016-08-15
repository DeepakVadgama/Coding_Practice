package general.java.elevator.test;

import general.java.elevator.Direction;
import general.java.elevator.ElevatorSystemManager;

public class TestElevatorSystem {

    public static void main(String[] args) throws InterruptedException {
        ElevatorSystemManager system = new ElevatorSystemManager(4, 0, 10);

        // Elevator requests
        system.addElevatorRequest(1, 3);
        system.addElevatorRequest(2, 6);
        system.addElevatorRequest(3, 8);

        // Floor requests
        system.addFloorRequest(Direction.UP, 4);
        system.addFloorRequest(Direction.DOWN, 10);

        while (true) {
            system.logState();
            Thread.sleep(1000);
        }
    }
}
