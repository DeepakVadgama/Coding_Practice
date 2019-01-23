package general.java.elevator;

public class Floor {

    private final int number;
    private final boolean isMax;
    private final boolean isMin;
    private boolean lightStatus;
    private FloorRequestManager requestManager;

    public Floor(int floorNumber, boolean isMax, boolean isMin, FloorRequestManager requestManager) {
        this.number = floorNumber;
        this.isMax = isMax;
        this.isMin = isMin;
        this.requestManager = requestManager;
        this.lightStatus = false;
    }

    public void request(Direction direction) {
        if (direction == Direction.DOWN) {
            requestDown();
        } else if (direction == Direction.UP) {
            requestUp();
        }
    }

    public void requestUp() {
        if (!isMax) {
            requestManager.addRequest(Direction.UP, number);
        }
    }

    public void requestDown() {
        if (!isMin) {
            requestManager.addRequest(Direction.DOWN, number);
        }
    }

}
