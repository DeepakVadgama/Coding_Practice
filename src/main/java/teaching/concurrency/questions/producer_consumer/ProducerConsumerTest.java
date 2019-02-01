package teaching.concurrency.questions.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        final Runnable producer = () -> {

            int ctr = 1;
            while (true) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // blocks if queue is full
                try {
                    queue.put(ctr++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread producerThread1 = new Thread(producer);
        Thread producerThread2 = new Thread(producer);

        final Runnable consumer = () -> {
            while (true) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // blocks if queue is empty
                int num = 0;
                try {
                    num = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num);
            }
        };
        Thread consumerThread1 = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer);
        Thread consumerThread3 = new Thread(consumer);

        producerThread1.start();
        producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

        Thread.sleep(1000);
    }

    private static Item getNextItem() {
        return new Item();
    }

    private static class Item {

    }
}
