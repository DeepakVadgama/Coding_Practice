package teaching.concurrency.questions.scatter_gather;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ScatterGather4 {

    String url1, url2, url3;
    ExecutorService threadPool = Executors.newFixedThreadPool(4);

    private Set<Integer> getPrices(int productId) throws InterruptedException {

        Collector collector = new Collector();

        threadPool.submit(new Task(url1, productId, collector));
        threadPool.submit(new Task(url2, productId, collector));
        threadPool.submit(new Task(url3, productId, collector));

        Set<Integer> prices = collector.getPrices();

        return prices;
    }

    private class Collector {

        private int taskCount;
        private Set<Integer> prices;
        private Lock lock = new ReentrantLock();
        private Condition complete = lock.newCondition();

        public void collect(int price) {
            lock.lock();
            prices.add(price);
            if (prices.size() == taskCount) {
                complete.signalAll();
            }
            lock.unlock();
        }

        public Set<Integer> getPrices() throws InterruptedException {
            lock.lock();
            complete.await();
            lock.unlock();
            return prices;
        }
    }

    private class Task implements Runnable {

        private Collector collector;

        public Task(String url1, int productId, Collector collector) {
            this.collector = collector;
        }

        @Override
        public void run() {
            int price = 0;
            // make http call
            collector.collect(price);
        }
    }
}
