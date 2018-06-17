package teaching.concurrency.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserAsCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Phaser phaser = new Phaser(3);
        executor.submit(new DependentService(phaser));
        executor.submit(new DependentService(phaser));
        executor.submit(new DependentService(phaser));

        phaser.awaitAdvance(1);

        System.out.println("All dependant services initialized");
        // program initialized, perform other operations
    }

    public static class DependentService implements Runnable {

        private Phaser phaser;

        public DependentService(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            // startup task
            phaser.arrive();
            // continue w/ other operations
        }
    }
}
