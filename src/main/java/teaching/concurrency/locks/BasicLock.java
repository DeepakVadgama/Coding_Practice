package teaching.concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("all")
public class BasicLock {

    private static ReentrantLock lock = new ReentrantLock();

    private static void accessResource() {

        lock.lock();

        // access the resource

        lock.unlock();
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

