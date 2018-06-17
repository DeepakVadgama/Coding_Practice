package teaching.concurrency.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;

public class PhaserAsCyclicBarrier_2 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Phaser phaser = new Phaser(3);
        executor.submit(new Task(phaser));
        executor.submit(new Task(phaser));
        executor.submit(new Task(phaser));

        Thread.sleep(2000);
    }

    public static class Task implements Runnable {

        private Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("Waiting for phaser" + Thread.currentThread().getName());
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();
                System.out.println("Sent message" + Thread.currentThread().getName());
                // send message to corresponding system
            }
        }
    }
}
