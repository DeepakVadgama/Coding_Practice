package teaching.concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("all")
public class TryLock {

    private static ReentrantLock lock = new ReentrantLock(true);

    private static void accessResource() {

        boolean lockAcquired = lock.tryLock();

        if (lockAcquired) {
            try {
                // access resource
            } finally {
                lock.unlock();
            }
        } else {
            // do alternate thing
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> accessResource());
        t1.start();
        Thread t2 = new Thread(() -> accessResource());
        t2.start();
        Thread t3 = new Thread(() -> accessResource());
        t3.start();
        Thread t4 = new Thread(() -> accessResource());
        t4.start();
    }
}

