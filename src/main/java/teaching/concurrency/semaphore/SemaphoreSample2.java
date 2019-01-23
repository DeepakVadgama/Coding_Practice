package teaching.concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreSample2 {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3);

        ExecutorService service = Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i -> service.execute(new Task(semaphore)));

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            // some processing

            semaphore.acquireUninterruptibly();
            // IO call to the slow service
            semaphore.release();

            // rest of processing
        }

        private final Semaphore semaphore;

        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

    }
}
