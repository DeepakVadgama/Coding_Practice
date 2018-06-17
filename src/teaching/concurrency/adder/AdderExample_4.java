package teaching.concurrency.adder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

public class AdderExample_4 {

    public static void main(String[] args) throws InterruptedException {

        LongAccumulator counter = new LongAccumulator((x, y) -> x + y, 0);
        LongAccumulator result = new LongAccumulator((x, y) -> x * y, 0);
        LongAccumulator min = new LongAccumulator((x, y) -> Math.min(x, y), Integer.MAX_VALUE);
        LongAccumulator max = new LongAccumulator((x, y) -> Math.max(x, y), Integer.MIN_VALUE);

        ExecutorService service = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 100; i++) {
            service.submit(new Task(counter));
        }

        Thread.sleep(2000);  // don't do this

        System.out.println(counter.get());
    }

    private static class Task implements Runnable {

        private final LongAccumulator counter;

        public Task(LongAccumulator counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            // some processing
            counter.accumulate(1);
        }
    }

}
