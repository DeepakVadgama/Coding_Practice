package teaching.concurrency.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    Object monitor = new String();
    private int count;
    private int MAX_COUNT;

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();

        new Thread(new Producer(isFull, isEmpty)).start();
        new Thread(new Consumer(isFull, isEmpty)).start();


    }

    public synchronized void execute() {

        // wait for monitor notify
        try {
            monitor.wait();
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }

        // notify thread waiting on the monitor
        monitor.notify();

        // notify all threads
        monitor.notifyAll();
    }

    public void execute2() {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();

        // wait for monitor notify
        try {
            condition.await();
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }

        // notify thread waiting on the monitor
        condition.signal();

        // notify all threads
        condition.signalAll();

        lock.unlock();
    }

    private Lock lock = new ReentrantLock();
    private Condition added = lock.newCondition();
    private Condition removed = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (count == MAX_COUNT)
                removed.await();

            addData();
            added.signal();

        } finally {
            lock.unlock();
        }
    }

    public String consume() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                added.await();

            String data = getData();
            removed.signal();

            return data;
        } finally {
            lock.unlock();
        }
    }

    private void addData() {


    }

    public void consume2() {
        lock.lock();
        try {
            // do some operations
            added.signal();
        } finally {
            lock.unlock();
        }
    }

    public String getData() {
        return null;
    }

    private static class Producer implements Runnable {


        public Producer(Condition isFull, Condition isEmpty) {

        }

        @Override
        public void run() {

        }
    }

    private static class Consumer implements Runnable {
        public Consumer(Condition isFull, Condition isEmpty) {


        }

        @Override
        public void run() {

        }
    }


}
