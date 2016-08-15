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

        // Setup elevators
        for (int i = 0; i < elevatorCount; i++) {
            elevators.put(i + 1, new Elevator(i + 1, minFloor, maxFloor, true));
        }

        // Setup floors
        floorRequestManager = new FloorRequestManager();
        for (int i = minFloor; i <= maxFloor; i++) {
            floors.put(i, new Floor(i, i == maxFloor, i == minFloor, floorRequestManager));
        }

        // Start elevators
        for (Elevator elevator : elevators.values()) {
            final Thread thread = new Thread(new ElevatorController(elevator, floorRequestManager));
            thread.setName("Elevator-" + elevator.getElevatorNumber());
            thread.start();
        }
    }

    public void addElevatorRequest(int elevatorNumber, int floor) {
        elevators.get(elevatorNumber).addRequest(floor);
    }

    public void addFloorRequest(Direction direction, int floor) {
        floors.get(floor).request(direction);
    }

    public void logState() {
        System.out.println();
        for (Elevator e : elevators.values()) {
            System.out.print("E" + e.getElevatorNumber() + " " + e.getCurrentFloor() + getDirectionSymbol(e.getDirection()) + ", ");
        }
        System.out.print(" Floor Up: " + floorRequestManager.getRequestsUp() + "," + floorRequestManager.getIntentToServeRequestsUp());
        System.out.print(" Floor Down: " + floorRequestManager.getRequestsDown() + "," + floorRequestManager.getIntentToServeRequestsDown());
    }

    private String getDirectionSymbol(Direction direction) {
        if (direction == Direction.DOWN) {
            return "\u2193";
        } else if (direction == Direction.UP) {
            return "\u2191";
        } else if (direction == Direction.STOP) {
            return "=";
        }
        return "";
    }
}
