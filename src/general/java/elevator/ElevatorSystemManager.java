package general.java.elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystemManager {

    private List<Elevator> elevators = new ArrayList<>();
    private List<Floor> floors = new ArrayList<>();

    public ElevatorSystemManager(int elevatorCount, int minFloor, int maxFloor) {

        if (elevatorCount < 0) {
            throw new IllegalArgumentException("Cannot have less than 0 elevators");
        }
        if (minFloor >= maxFloor) {
            throw new IllegalArgumentException("Min floor cannot be more or same as max floor");
        }

        // Initialize system
        for (int i = 0; i < elevatorCount; i++) {
            elevators.add(new Elevator(i + 1, minFloor, maxFloor, true));
        }

        FloorRequestManager floorRequestManager = new FloorRequestManager();
        for (int i = minFloor; i <= maxFloor; i++) {
            floors.add(new Floor(i, i == maxFloor, i == minFloor, floorRequestManager));
        }
    }

    public void deactivate(int elevatorNumber) {
        // Let it do its thing then deactivate.
    }

    public void activate(int elevatorNumber) {
        // Let it do its thing then deactivate.
    }

}
