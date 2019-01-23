package teaching.parallelism;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("all")
public class ConcurrencyExample2 {

    private static int ticketsAvailable = 2;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            lock.lock();
            if (ticketsAvailable > 0) {
                bookTicket();
                ticketsAvailable--;
            }
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            if (ticketsAvailable > 0) {
                bookTicket();
                ticketsAvailable--;
            }
            lock.unlock();
        }).start();

        Thread.sleep(5000);
    }

    private static void bookTicket() {

    }
}
