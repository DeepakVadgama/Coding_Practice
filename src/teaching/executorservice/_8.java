package teaching.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _8 {

    public static void main(String[] args) {

        // create the single-thread-pool
        ExecutorService service = Executors.newSingleThreadExecutor();

        // submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }

}
