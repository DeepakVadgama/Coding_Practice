package teaching.concurrency.deadlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockBasics {

    public static void main(String[] args) throws InterruptedException {

        DeadLockBasics basics = new DeadLockBasics();
        basics.execute();

        Thread.sleep(100000);
    }

    private Lock lockA = new ReentrantLock();
    private Lock lockB = new ReentrantLock();

    private void execute() {
        Thread t1 = new Thread(this::processThis);
        Thread t2 = new Thread(this::processThat);

        t1.start();
        t2.start();
    }

    public void processThis() {
        lockA.lock();
        // process resource A

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lockB.lock();
        // process resource A and B

        lockA.unlock();
        lockB.unlock();
    }

    public void processThat() {
        lockB.lock();
        // process resource B

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lockA.lock();
        // process resource A and B

        lockA.unlock();
        lockB.unlock();
    }
}
