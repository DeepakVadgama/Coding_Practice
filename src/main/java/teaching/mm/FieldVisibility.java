package teaching.mm;

public class FieldVisibility {

    int x = 0;

    public void writerThread() {
        x = 1;
    }

    public void readerThread() {
        int r2 = x;
    }
}
