package general.java.elevator;

import java.util.TreeSet;

import static general.java.elevator.Direction.*;

/**
 * Controls movement of Elevator.
 */
public class ElevatorController implements Runnable {

    private final Elevator elevator;
    private FloorRequestManager floorRequests;
    public static final int THRESHOLD = 2;

    public ElevatorController(Elevator elevator, FloorRequestManager floorRequests) {
        this.elevator = elevator;
        this.floorRequests = floorRequests;
    }

    @Override
    public void run() {

        while (true) {

            // Remove any floor requests for current floor in elevator direction
            elevator.removeRequest(elevator.getDirection(), elevator.getCurrentFloor());
            floorRequests.removeRequest(elevator.getDirection(), elevator.getCurrentFloor());
            floorRequests.removeIntentRequest(elevator.getDirection(), elevator.getCurrentFloor());

            // 1. If moving, and any floor requests in same direction. Serve. 
            // If any within threshold move to own requests queue and serve.
            if (isMoving()) {

                // Stop if all requests served, and no new requests added. 
                if (elevator.allFloorsServed()) {
                    elevator.stop();
                }

                simulateSlowness();
                elevator.move();

                markIntentToServe();
                moveAnyWithinThreshold();
            }

            Integer targetFloor;

            // 2. If not moving and any elevator requests. set direction and move. 
            targetFloor = elevator.getClosestFirstRequest();
            if (targetFloor != null && isNotMoving()) {
                setDirectionAndMove(targetFloor);
            }

            // Dev note: Tricky bit. Read example: 
            // If Elevator1 at floor 2, says, I show intent to fulfill request of floor 8
            // It moves request from FloorRequestManager to IntentToServeRequests
            // If Elevator2 at floor 7, just finished serving all internal requests. 
            // Elevator2 should snatch the request from Elevator1 (its more efficient).
            // Elevator1 should realize other is taking care of request and should stop.

            // 3. If any intent-to-serve requests within threshold (2), then move to our own queue and serve.
            targetFloor = moveAnyWithinThreshold();
            if (targetFloor != null && isNotMoving()) {
                setDirectionAndMove(targetFloor);
            }

            // 4. Any floor requests present, add to intent-to-serve and start moving.
            targetFloor = markIntentToServe();
            if (targetFloor != null && isNotMoving()) {
                setDirectionAndMove(targetFloor);
            }
        }
    }

    // TODO: This is total mess. Clean it up.
    private Integer moveAnyWithinThreshold() {

        final TreeSet<Integer> intentDown = floorRequests.getIntentToServeRequestsDown();
        final TreeSet<Integer> intentUp = floorRequests.getIntentToServeRequestsUp();

        final int currentFloor = elevator.getCurrentFloor();
        Integer targetFloor = null;
        if (isMoving()) {
            final Direction direction = elevator.getDirection();
            if (direction == DOWN) {

                synchronized (intentDown) {
                    if (!intentDown.isEmpty()) {
                        if (isWithinThreshold(currentFloor, intentDown.first())) {
                            targetFloor = intentDown.pollFirst();
                            elevator.getRequestsDown().add(targetFloor);
                        }
                    }
                }

            } else if (direction == UP) {

                synchronized (intentDown) {
                    if (!intentUp.isEmpty()) {
                        if (isWithinThreshold(currentFloor, intentUp.first())) {
                            targetFloor = intentUp.pollFirst();
                            elevator.getRequestsUp().add(targetFloor);
                        }
                    }
                }
            }
        } else {
            synchronized (intentUp) {
                if (!intentUp.isEmpty()) {
                    if (isWithinThreshold(currentFloor, intentUp.first())) {
                        targetFloor = intentUp.pollFirst();
                        elevator.getRequestsUp().add(targetFloor);
                    }
                    return targetFloor;
                }
            }

            synchronized (intentDown) {
                if (!intentDown.isEmpty()) {
                    if (isWithinThreshold(currentFloor, intentDown.first())) {
                        targetFloor = intentDown.pollFirst();
                        elevator.getRequestsDown().add(targetFloor);
                    }
                    return targetFloor;
                }
            }
        }
        return targetFloor;
    }

    private boolean isWithinThreshold(int currentFloor, Integer targetFloor) {
        return targetFloor != null && Math.abs(currentFloor - targetFloor) <= THRESHOLD;
    }

    private Integer markIntentToServe() {

        final TreeSet<Integer> requestsDown = floorRequests.getRequestsDown();
        final TreeSet<Integer> requestsUp = floorRequests.getRequestsUp();

        if (isMoving()) {
            final Direction direction = elevator.getDirection();
            if (direction == DOWN && !requestsDown.isEmpty()) {
                return floorRequests.markAsIntent(direction);
            } else if (direction == UP && !requestsUp.isEmpty()) {
                return floorRequests.markAsIntent(direction);
            }
        } else {
            if (!requestsUp.isEmpty()) {
                return floorRequests.markAsIntent(UP);
            } else if (!requestsDown.isEmpty()) {
                return floorRequests.markAsIntent(DOWN);
            }
        }
        return null;
    }

    private boolean isMoving() {
        return elevator.getDirection() != STOP;
    }

    private void setDirectionAndMove(Integer targetFloor) {
        if (targetFloor > elevator.getCurrentFloor()) {
            elevator.setDirection(UP);
        } else if (targetFloor < elevator.getCurrentFloor()) {
            elevator.setDirection(DOWN);
        }
        simulateSlowness();
        elevator.move();
    }

    private boolean isNotMoving() {
        return elevator.getDirection() == STOP;
    }

    private void simulateSlowness() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Error while moving lift");
        }
    }
}
