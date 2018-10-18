package teaching.concurrency.locks.striped;

import com.google.common.util.concurrent.Striped;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyProblem {

    public static void main(String[] args) {

        Bag bag = new Bag();

        Lock lock = new ReentrantLock();

        lock.lock();
        if (!bag.hasBlueCandy()) {
            bag.add(new Candy("blue"));
        }
        lock.unlock();


    }

    private Striped<Lock> stripedLocks = Striped.lock(10);

    public void update(Bag bag) {

        Lock lock = stripedLocks.get(bag);

        lock.lock();
        if (!bag.hasBlueCandy()) {
            bag.add(new Candy("blue"));
        }
        lock.unlock();
    }
}
