package teaching.concurrency.adder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class AdderExample {

    public static void main(String[] args) throws InterruptedException {

        AtomicLong counter = new AtomicLong(0);

        ExecutorService service = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 100; i++) {
            service.submit(new Task(counter));
        }

        Thread.sleep(2000);  // don't do this

        System.out.println(counter.get());
    }

    private static class Task implements Runnable {

        private final AtomicLong counter;

        public Task(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            // some processing
            counter.incrementAndGet();
        }
    }

}
