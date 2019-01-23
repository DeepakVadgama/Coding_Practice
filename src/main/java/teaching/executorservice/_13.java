package teaching.executorservice;

import java.util.Random;
import java.util.concurrent.*;

public class _13 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        // submit task and accept the placeholder object for return value
        Future<Integer> future = service.submit(new Task());

        // some optional unrelated operations

        // get the task return value (this may block until task is completed)

        // Cancel the task
        future.cancel(false);

        // Returns true if task was cancelled
        future.isCancelled();

        // Returns true is task is completed (successfully or otherwise)
        future.isDone();

        try {
            Integer result = future.get(1, TimeUnit.SECONDS);
            System.out.println("Result from the task is " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Couldn't complete task before timeout");
        }
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

}
