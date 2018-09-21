package teaching.concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("all")
public class HoldCount {

    private static ReentrantLock lock = new ReentrantLock();

    private static void accessResource() {

        lock.lock();

        // update shared resource

        if (someCondition()) {
            accessResource();
        }

        lock.unlock();
    }

    private static boolean someCondition() {
        return false;
    }

    public static void main(String[] args) {

//        Thread t1 = new Thread(() -> accessResource());
//        t1.start();
//        Thread t2 = new Thread(() -> accessResource());
//        t2.start();
//        Thread t3 = new Thread(() -> accessResource());
//        t3.start();
//        Thread t4 = new Thread(() -> accessResource());
//        t4.start();
    }
}

