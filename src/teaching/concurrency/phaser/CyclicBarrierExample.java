package teaching.concurrency.phaser;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        CyclicBarrier barrier = new CyclicBarrier(3);
        executor.submit(new Task(barrier));
        executor.submit(new Task(barrier));
        executor.submit(new Task(barrier));

        Thread.sleep(5000);
    }

    public static class Task implements Runnable {

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("Waiting for barrier" + Thread.currentThread().getName());
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("Sent message" + Thread.currentThread().getName());

                // send message to corresponding system
            }
        }
    }
}
