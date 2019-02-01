package teaching.concurrency.questions.scatter_gather;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ScatterGather5 {

    String url1, url2, url3;

    private Set<Integer> getPrices(int productId) throws InterruptedException, TimeoutException, ExecutionException {

        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task(url1, productId, prices));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task(url2, productId, prices));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task(url3, productId, prices));

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        allTasks.get(3, TimeUnit.SECONDS);

        return prices;
    }

    private class Task implements Runnable {

        private String url;
        private int productId;
        private Set<Integer> prices;

        public Task(String url1, int productId, Set<Integer> prices) {
            this.url = url;
            this.productId = productId;
            this.prices = prices;
        }

        @Override
        public void run() {
            int price = 0;
            // make http call
            prices.add(price);
        }
    }
}
