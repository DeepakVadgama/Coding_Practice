package teaching.mm;

public class VolatileVisibility {

    volatile boolean flag = true;

    public void writerThread() {
        flag = false;
    }

    public void readerThread() {
        while (flag) {
            // do some operations
        }
    }
}


