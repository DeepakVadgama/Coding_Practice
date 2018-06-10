package teaching.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _5 {

    public static void main(String[] args) {

        // much higher count for IO tasks
        ExecutorService service = Executors.newFixedThreadPool(100);

        // submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new IOTask());
        }
    }

    static class IOTask implements Runnable {
        public void run() {
            // some IO operations which will cause thread to block/wait
        }
    }

}
