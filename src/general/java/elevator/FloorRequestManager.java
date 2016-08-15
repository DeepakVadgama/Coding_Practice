package general.java.elevator;

import java.util.concurrent.ConcurrentSkipListSet;

public class FloorRequestManager {

    // Pending floor requests
    private ConcurrentSkipListSet<Integer> requestsUp = new ConcurrentSkipListSet<>();
    private ConcurrentSkipListSet<Integer> requestsDown = new ConcurrentSkipListSet<>();

    // Requests where Elevator has shown intent to serve 
    private ConcurrentSkipListSet<Integer> intentToServeRequestsUp = new ConcurrentSkipListSet<>();
    private ConcurrentSkipListSet<Integer> intentToServeRequestsDown = new ConcurrentSkipListSet<>();

    public FloorRequestManager() {
    }

    public void addRequest(Direction direction, int fromFloor) {
        if (Direction.DOWN == direction) {
            requestsDown.add(fromFloor);
        } else {
            requestsUp.add(fromFloor);
        }
    }

    public void removeRequest(Direction direction, int floor) {
        if (Direction.DOWN == direction) {
            requestsDown.remove(floor);
        } else {
            requestsUp.remove(floor);
        }
    }

    public void removeIntentRequest(Direction direction, int floor) {
        if (Direction.DOWN == direction) {
            intentToServeRequestsDown.remove(floor);
        } else {
            intentToServeRequestsUp.remove(floor);
        }
    }

    public ConcurrentSkipListSet<Integer> getRequestsUp() {
        return requestsUp;
    }

    public ConcurrentSkipListSet<Integer> getRequestsDown() {
        return requestsDown;
    }

    public ConcurrentSkipListSet<Integer> getIntentToServeRequestsUp() {
        return intentToServeRequestsUp;
    }

    public ConcurrentSkipListSet<Integer> getIntentToServeRequestsDown() {
        return intentToServeRequestsDown;
    }

    public Integer markAsIntent(Direction direction) {
        Integer floor = null;
        if (Direction.UP == direction) {
            floor = requestsUp.pollFirst();
            if (floor != null) {
                intentToServeRequestsUp.add(floor);
            }
        } else if (Direction.DOWN == direction) {
            floor = requestsDown.pollFirst();
            if (floor != null) {
                intentToServeRequestsDown.add(floor);
            }
        }
        return floor;
    }
}
