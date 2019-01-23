package teaching.concurrency.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Temp {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new Task(counter));
        service.execute(new Task(counter));
        service.execute(new Task(counter));
        service.execute(new Task(counter));
        service.execute(new Task(counter));
        service.execute(new Task(counter));
        service.execute(new Task(counter));

        Thread.sleep(1000);
        System.out.println(counter.get());
    }

    private static class Task implements Runnable {


        private final AtomicInteger counter;

        public Task(AtomicInteger counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.incrementAndGet();
        }
    }
}
