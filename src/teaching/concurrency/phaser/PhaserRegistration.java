package teaching.concurrency.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserRegistration {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Phaser phaser = new Phaser(1);

        executor.submit(new Service(phaser));
        executor.submit(new Service(phaser));

        phaser.arriveAndAwaitAdvance();

        phaser.bulkRegister(4);
    }

    public static class Service implements Runnable {

        private Phaser phaser;

        public Service(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            phaser.register();
            // some operations
            phaser.arriveAndDeregister();
            // other operations
        }
    }
}
