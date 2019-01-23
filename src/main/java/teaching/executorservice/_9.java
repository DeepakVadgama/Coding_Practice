package teaching.executorservice;

import java.util.concurrent.*;

public class _9 {

    public static void main(String[] args) {

        // create the single-thread-pool
        ExecutorService service
                = new ThreadPoolExecutor(
                10,
                100,
                120, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(300));

        try {
            service.execute(new Task());
        } catch (RejectedExecutionException e) {
            System.err.println("task rejected " + e.getMessage());
        }
    }

    private static class CustomRejectionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // logging / operations to perform on rejection
        }
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }
}
