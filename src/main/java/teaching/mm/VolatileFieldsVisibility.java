package teaching.mm;

public class VolatileFieldsVisibility {

    int a = 0, b = 0, c = 0;
    volatile int x = 0;

    public void writerThread() {

        a = 1;
        b = 1;
        c = 1;

        x = 1;  // write of x
    }

    public void readerThread() {

        int r2 = x;   // read of x 

        int d1 = a;
        int d2 = b;
        int d3 = c;
    }
}


