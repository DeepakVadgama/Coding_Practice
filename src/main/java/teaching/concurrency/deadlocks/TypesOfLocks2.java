package teaching.concurrency.deadlocks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TypesOfLocks2 {

    private void execute() throws InterruptedException {

        Lock lock = new ReentrantLock();
        boolean acquired = lock.tryLock(2, TimeUnit.SECONDS);

        BlockingQueue queue = new ArrayBlockingQueue(16);
        queue.poll(2, TimeUnit.SECONDS);

        Semaphore sem = new Semaphore(1);
        sem.tryAcquire(2, TimeUnit.SECONDS);
    }

    public synchronized void process() {

    }

    public static synchronized void count() {
    }
}
