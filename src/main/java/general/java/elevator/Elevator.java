package general.java.elevator;

import java.util.Set;
import java.util.TreeSet;

public class Elevator {

    private final int elevatorNumber;
    private final int max;
    private final int min;
    private int currentFloor = 0;
    private Direction direction = Direction.UP;
    private boolean activated;
    private final TreeSet<Integer> requestsUp = new TreeSet<>();
    private final TreeSet<Integer> requestsDown = new TreeSet<>();

    public Elevator(int elevatorNumber, int minFloor, int maxFloor, boolean activated) {
        this.elevatorNumber = elevatorNumber;
        this.min = minFloor;
        this.max = maxFloor;
        this.activated = activated;
    }

    public void addRequest(int floor) {
        if (floor > currentFloor) {
            requestsUp.add(floor);
        } else if (floor < currentFloor) {
            requestsDown.add(floor);
        }
    }

    public void move() {
        if (Direction.DOWN == direction) {
            moveDown();
        } else if (Direction.UP == direction) {
            moveUp();
        }
    }

    public void moveUp() {
        if (activated && currentFloor != max) {
            currentFloor++;
        }
    }

    public void moveDown() {
        if (activated && currentFloor != min) {
            currentFloor--;
        }
    }

    public void deactivate() {
        activated = false;
    }

    public void activate() {
        activated = true;
    }

    public int getElevatorNumber() {
        return elevatorNumber;
    }

    public Set<Integer> getRequestsUp() {
        return requestsUp;
    }

    public Set<Integer> getRequestsDown() {
        return requestsDown;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void removeRequest(Direction direction, int floor) {
        if (Direction.DOWN == direction) {
            requestsDown.remove(floor);
        } else {
            requestsUp.remove(floor);
        }
    }

    public Integer getClosestFirstRequest() {
        if (requestsDown.isEmpty() && requestsUp.isEmpty()) {
            return null;
        }
        if (!requestsDown.isEmpty() && requestsUp.isEmpty()) {
            return requestsDown.first();
        }
        if (requestsDown.isEmpty() && !requestsUp.isEmpty()) {
            return requestsUp.first();
        }
        final int downDelta = Math.abs(currentFloor - requestsDown.first());
        final int upDelta = Math.abs(currentFloor - requestsUp.first());
        return downDelta < upDelta ? requestsDown.first() : requestsUp.first();
    }

    public boolean allFloorsServed() {
        if (Direction.DOWN == direction && requestsDown.isEmpty()) {
            return true;
        }
        if (Direction.UP == direction && requestsUp.isEmpty()) {
            return true;
        }
        return false;
    }

    public void stop() {
        direction = Direction.STOP;
    }
}
