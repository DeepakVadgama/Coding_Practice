package teaching.concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreSample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i -> service.execute(new Task()));

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            // some processing 
            // IO call to the slow service
            // rest of processing
        }
    }
}
