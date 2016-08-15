package general.java.elevator;


import java.util.TreeSet;

import static general.java.elevator.Direction.DOWN;
import static general.java.elevator.Direction.UP;

public class FloorRequestManager {

    // Pending floor requests
    private TreeSet<Integer> requestsUp = new TreeSet<>();
    private TreeSet<Integer> requestsDown = new TreeSet<>();

    // Requests where Elevator has shown intent to serve 
    private TreeSet<Integer> intentToServeRequestsUp = new TreeSet<>();
    private TreeSet<Integer> intentToServeRequestsDown = new TreeSet<>();

    public FloorRequestManager() {
    }

    public void addRequest(Direction direction, int fromFloor) {
        if (DOWN == direction) {
            requestsDown.add(fromFloor);
        } else {
            requestsUp.add(fromFloor);
        }
    }

    public void removeRequest(Direction direction, int floor) {
        if (DOWN == direction) {
            requestsDown.remove(floor);
        } else {
            requestsUp.remove(floor);
        }
    }

    public void removeIntentRequest(Direction direction, int floor) {
        if (DOWN == direction) {
            intentToServeRequestsDown.remove(floor);
        } else {
            intentToServeRequestsUp.remove(floor);
        }
    }

    public TreeSet<Integer> getRequestsUp() {
        return requestsUp;
    }

    public TreeSet<Integer> getRequestsDown() {
        return requestsDown;
    }

    public TreeSet<Integer> getIntentToServeRequestsUp() {
        return intentToServeRequestsUp;
    }

    public TreeSet<Integer> getIntentToServeRequestsDown() {
        return intentToServeRequestsDown;
    }

    public Integer markAsIntent(Direction direction) {
        Integer floor = null;
        if (UP == direction) {
            synchronized (requestsUp) {
                synchronized (intentToServeRequestsUp) {
                    floor = requestsUp.pollFirst();
                    if (floor != null) {
                        intentToServeRequestsUp.add(floor);
                    }
                }
            }
        } else if (DOWN == direction) {
            synchronized (requestsDown) {
                synchronized (intentToServeRequestsDown) {
                    floor = requestsDown.pollFirst();
                    if (floor != null) {
                        intentToServeRequestsDown.add(floor);
                    }
                }
            }
        }
        return floor;
    }
}
