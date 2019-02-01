package teaching.concurrency.questions.scatter_gather;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ScatterGather3 {

    String url1, url2, url3;
    ExecutorService threadPool = Executors.newFixedThreadPool(4);

    private Set<Integer> getPrices(int productId) throws InterruptedException {

        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
        Lock lock = new ReentrantLock();
        Condition allTasksComplete = lock.newCondition();

        threadPool.submit(new Task(url1, productId, prices, allTasksComplete));
        threadPool.submit(new Task(url2, productId, prices, allTasksComplete));
        threadPool.submit(new Task(url3, productId, prices, allTasksComplete));

        allTasksComplete.await();

        return prices;
    }

    private class Task implements Runnable {

        private String url;
        private int productId;
        private Set<Integer> prices;
        private Condition allTasksComplete;

        public Task(String url, int productId, Set<Integer> prices, Condition allTasksComplete) {
            this.url = url;
            this.productId = productId;
            this.prices = prices;
            this.allTasksComplete = allTasksComplete;
        }

        @Override
        public void run() {
            int price = 0;
            // make http call
            prices.add(price);
            if (prices.size() == 3) {
                allTasksComplete.signalAll();
            }
        }
    }
}
