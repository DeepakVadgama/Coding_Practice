package teaching.concurrency.deadlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockBasicsSolved {

    public static void main(String[] args) throws InterruptedException {

        DeadLockBasicsSolved basics = new DeadLockBasicsSolved();
        basics.execute();

        Thread.sleep(10000);
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

        lockB.lock();
        // process resource A and B

        lockA.unlock();
        lockB.unlock();
    }

    public void processThat() {

        lockA.lock();
        lockB.lock();
        // process resource B
        // process resource A and B

        lockA.unlock();
        lockB.unlock();
    }
}
