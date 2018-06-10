package teaching.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class _12 {

    public static void main(String[] args) {

        // create the pool
        ExecutorService service = Executors.newFixedThreadPool(10);

        // submit the tasks for execution
        List<Future> allFutures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Integer> future = service.submit(new Task());
            allFutures.add(future);
        }

        // 100 futures, with 100 placeholders. 

        // perform some unrelated operations

        // 100 seconds
        for (int i = 0; i < 100; i++) {
            Future<Integer> future = allFutures.get(i);
            try {
                Integer result = future.get(); // blocking
                System.out.println("Result of future #" + i + "=" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }

}
