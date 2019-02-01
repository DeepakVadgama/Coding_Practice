package teaching.concurrency.questions.scatter_gather;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScatterGather2 {

    String url1, url2, url3;
    ExecutorService threadPool = Executors.newFixedThreadPool(4);

    private Set<Integer> getPrices(int productId) throws InterruptedException {

        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
        CountDownLatch latch = new CountDownLatch(3);

        threadPool.submit(new Task(url1, productId, prices, latch));
        threadPool.submit(new Task(url2, productId, prices, latch));
        threadPool.submit(new Task(url3, productId, prices, latch));

        latch.await();
        latch.await(3, TimeUnit.SECONDS);

        return prices;
    }

    private class Task implements Runnable {

        private String url;
        private int productId;
        private Set<Integer> prices;
        private CountDownLatch latch;

        public Task(String url, int productId, Set<Integer> prices, CountDownLatch latch) {
            this.url = url;
            this.productId = productId;
            this.prices = prices;
            this.latch = latch;
        }

        @Override
        public void run() {
            int price = 0;
            // make http call
            prices.add(price);
            latch.countDown();
        }
    }

}
