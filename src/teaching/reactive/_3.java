package teaching.reactive;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }

    private void printDBValue() throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<String> future = service.submit(() -> {
            // fetch from DB
            return "fetched-value";
        });

        String futureValue = future.get(); // blocking
        System.out.println(futureValue);

    }

}
