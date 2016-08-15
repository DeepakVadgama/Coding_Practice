package general.java.elevator;

/**
 * Controls movement of Elevator.
 */
public class ElevatorController implements Runnable {

    private final Elevator elevator;
    private FloorRequestManager floorRequests;

    public ElevatorController(Elevator elevator, FloorRequestManager floorRequests) {
        this.elevator = elevator;
        this.floorRequests = floorRequests;
    }

    @Override
    public void run() {

        while (true) {

            // Remove any floor requests for current floor
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
        if (isMoving()) {
            final Direction direction = elevator.getDirection();
            if (Direction.DOWN == direction && !floorRequests.getIntentToServeRequestsDown().isEmpty()) {
                final Integer floor = floorRequests.getIntentToServeRequestsDown().pollFirst();
                elevator.getRequestsDown().add(floor);
                return floor;
            } else if (Direction.UP == direction && !floorRequests.getIntentToServeRequestsUp().isEmpty()) {
                final Integer floor = floorRequests.getIntentToServeRequestsUp().pollFirst();
                elevator.getRequestsUp().add(floor);
                return floor;
            }
        } else {
            if (!floorRequests.getIntentToServeRequestsUp().isEmpty()) {
                final Integer floor = floorRequests.getIntentToServeRequestsUp().pollFirst();
                elevator.getRequestsUp().add(floor);
                return floor;
            } else if (!floorRequests.getIntentToServeRequestsDown().isEmpty()) {
                final Integer floor = floorRequests.getIntentToServeRequestsDown().pollFirst();
                elevator.getRequestsDown().add(floor);
                return floor;
            }
        }
        return null;
    }

    private Integer markIntentToServe() {
        if (isMoving()) {
            final Direction direction = elevator.getDirection();
            if (Direction.DOWN == direction && !floorRequests.getRequestsDown().isEmpty()) {
                return floorRequests.markAsIntent(direction);
            } else if (Direction.UP == direction && !floorRequests.getRequestsUp().isEmpty()) {
                return floorRequests.markAsIntent(direction);
            }
        } else {
            if (!floorRequests.getRequestsUp().isEmpty()) {
                return floorRequests.markAsIntent(Direction.UP);
            } else if (!floorRequests.getRequestsDown().isEmpty()) {
                return floorRequests.markAsIntent(Direction.DOWN);
            }
        }
        return null;
    }

    private boolean isMoving() {
        return elevator.getDirection() != Direction.STOP;
    }

    private void setDirectionAndMove(Integer targetFloor) {
        if (targetFloor > elevator.getCurrentFloor()) {
            elevator.setDirection(Direction.UP);
        } else if (targetFloor < elevator.getCurrentFloor()) {
            elevator.setDirection(Direction.DOWN);
        }
        simulateSlowness();
        elevator.move();
    }

    private boolean isNotMoving() {
        return elevator.getDirection() == Direction.STOP;
    }

    private void simulateSlowness() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Error while moving lift");
        }
    }
}
