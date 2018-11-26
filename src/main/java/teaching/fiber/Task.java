package teaching.fiber;

import java.util.concurrent.locks.ReentrantLock;

public class Task {

    private ReentrantLock lock;

    public void task() {

        Fibers.execute(() -> {
            calculations();
            lock.lock();
            updateSharedResource();
            lock.unlock();
        });
    }

    private void updateSharedResource() {

    }

    private void calculations() {

    }

    private static class Fibers {

        public static void execute(Runnable r) {

        }
    }
}
