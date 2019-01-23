package teaching.executorservice;

import java.util.Random;
import java.util.concurrent.*;

public class _11 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        // submit task and accept the placeholder object for return value
        Future<Integer> future = service.submit(new Task());

        // some optional unrelated operations

        // get the task return value (this may block until task is completed)
        try {
            Integer result = future.get();
            System.out.println("Result from the task is " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

}
