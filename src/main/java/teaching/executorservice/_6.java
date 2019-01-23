package teaching.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _6 {

    public static void main(String[] args) {

        // for lot of short lived tasks
        ExecutorService service = Executors.newCachedThreadPool();

        // submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
    }

    static class Task implements Runnable {
        public void run() {
            // short lived task
        }
    }

}
