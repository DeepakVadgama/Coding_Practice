package general.java.elevator;

import java.util.HashMap;
import java.util.Map;

public class ElevatorSystemManager {

    private final Map<Integer, Elevator> elevators = new HashMap<>();
    private final Map<Integer, Floor> floors = new HashMap<>();
    private final FloorRequestManager floorRequestManager;

    public ElevatorSystemManager(int elevatorCount, int minFloor, int maxFloor) {

        if (elevatorCount < 0) {
            throw new IllegalArgumentException("Cannot have less than 0 elevators");
        }
        if (minFloor >= maxFloor) {
            throw new IllegalArgumentException("Min floor cannot be more or same as max floor");
        }

        // Initialize system
        for (int i = 0; i < elevatorCount; i++) {
            elevators.put(i + 1, new Elevator(i + 1, minFloor, maxFloor, true));
        }

        floorRequestManager = new FloorRequestManager();
        for (int i = minFloor; i <= maxFloor; i++) {
            floors.put(i, new Floor(i, i == maxFloor, i == minFloor, floorRequestManager));
        }
    }

    public void addElevatorRequest(int elevatorNumber, int floor) {
        elevators.get(elevatorNumber).addRequest(floor);
    }

    public void addFloorRequest(Direction direction, int floor) {
        floors.get(floor).requestUp();
    }

}
