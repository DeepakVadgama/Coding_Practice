package teaching.concurrency.questions.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);

        final Runnable producer = () -> {

            while (true) {
                // blocks if queue is full
                try {
                    queue.put(createItem());
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
                    // blocks if queue is empty
                    Item i = queue.take();
                    process(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

    private static void process(Item i) {

    }

    private static Item createItem() {
        return new Item();
    }

    private static class Item {

    }
}
