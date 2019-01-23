package general.java.criteriaqueue.test;


import general.java.criteriaqueue.CriteriaBasedConcurrentQueue;

public class TestCustomQueue {

    private static CriteriaBasedConcurrentQueue<Candy> queue = new CriteriaBasedConcurrentQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Producer(queue, 300), "Producer 1").start();
        new Thread(new Producer(queue, 600), "Producer 2").start();
        new Thread(new Consumer(queue, 900, "RED"), "Consumer Red").start();
        new Thread(new Consumer(queue, 200, "GREEN"), "Consumer Green").start();
        new Thread(new Consumer(queue, 400, "BLUE"), "Consumer Blue").start();

        Thread.sleep(20000);
    }

    public static class Producer implements Runnable {

        private final CriteriaBasedConcurrentQueue<Candy> queue;
        private final int prodSpeed; // Production speed in millis

        public Producer(CriteriaBasedConcurrentQueue<Candy> queue, int prodSpeed) {
            this.queue = queue;
            this.prodSpeed = prodSpeed;
        }

        @Override
        public void run() {
            while (true) {
                final Candy candy = CandyFactory.getCandy();
                queue.put(candy);
                System.out.println("Added candy: " + candy);
                try {
                    Thread.sleep(prodSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Consumer implements Runnable {

        private final CriteriaBasedConcurrentQueue<Candy> queue;
        private final int consSpeed; // Consumption speed in millis
        private final String color;

        public Consumer(CriteriaBasedConcurrentQueue<Candy> queue, int consSpeed, String color) {
            this.queue = queue;
            this.consSpeed = consSpeed;
            this.color = color;
        }

        @Override
        public void run() {
            while (true) {
                final Candy candy = queue.get(color);
                System.out.println("Got candy: " + candy);
                try {
                    Thread.sleep(consSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
