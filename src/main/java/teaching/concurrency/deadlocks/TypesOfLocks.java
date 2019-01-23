package teaching.concurrency.deadlocks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TypesOfLocks {

    private void execute() throws InterruptedException {

        Lock lock = new ReentrantLock();
        lock.lock();

        BlockingQueue queue = new ArrayBlockingQueue(16);
        queue.take();

        Semaphore sem = new Semaphore(1);
        sem.acquire();
    }

    public synchronized void process() {

    }

    public static synchronized void count() {
    }
}
