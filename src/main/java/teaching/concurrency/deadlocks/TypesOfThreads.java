package teaching.concurrency.deadlocks;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TypesOfThreads {

    private void execute() {

        Thread t1 = new Thread();
        t1.start();

        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.submit(() -> { /** task **/});

        ScheduledExecutorService schedulers = Executors.newScheduledThreadPool(1);
        schedulers.schedule(() -> { /** task **/}, 10, TimeUnit.SECONDS);
    }

    @RequestMapping("/user/32")
    public void userDetails() {

    }
}
