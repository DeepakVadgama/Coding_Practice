package teaching.concurrency.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserAsCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Phaser phaser = new Phaser(3);
        executor.submit(new Task(phaser));
        executor.submit(new Task(phaser));
        executor.submit(new Task(phaser));

        Thread.sleep(3000);
    }

    public static class Task implements Runnable {

        private Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {

            while (true) {
                phaser.arriveAndAwaitAdvance();
                // send message to corresponding system
            }
        }
    }
}
