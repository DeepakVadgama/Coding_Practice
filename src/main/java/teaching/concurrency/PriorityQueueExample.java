//package teaching.concurrency;
//
//
//import java.util.ArrayList;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.Executors;
//
//
//public class PriorityQueueExample {
//
//    //private static PriorityQueue pq;
//    private static BlockingQueue<Integer> pq;
//
//    public static void main(String[] args) {
//
//        ArrayList<String> list = new ArrayList<>();
//        list.forEach();
//
//        list.stream().
//                ExecutorService es = Executors.newFixedThreadPool(5);
//        //pq  = new PriorityQueue(10);
//        pq = new ArrayBlockingQueue<>(100);
//        System.out.println("MAIN INITIAL--QSIZE=" + pq.size());
//        CountDownLatch cdl = new CountDownLatch(100); //using this to assure PROD/CONS are over
//        //System.out.println(cdl.getCount());
//        for (int i = 0; i < 100; i++) {
//            es.submit(new Producer(pq, i, cdl));
//            es.submit(new Consumer(pq, cdl));
//        }
//        System.out.println(Thread.currentThread().getName() + "--B4 AWAIT :Q-SIZE-----" + pq.size());
//        try {
//            cdl.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + "--AFTER AWAIT :Q-SIZE----" + pq.size());
//
//        //es.awaitTermination(10, TimeUnit.SECONDS);
//        //es.shutdown();
//        es.shutdown();
//        System.out.println("MAIN EXITS----QSIZE=" + pq.size());
//    }
//
//}
//
//class Producer implements Runnable {
//    //PriorityQueue pq;
//    private BlockingQueue bq;
//    private CountDownLatch producerLatch;
//    private int x;
//
//    public Producer(BlockingQueue pq, int i, CountDownLatch producerLatch) {
//        //this.pq=pq;
//        this.bq = pq;
//        this.x = i;
//        this.producerLatch = producerLatch;
//    }
//
//    public void run() {
//        //pq.offer(x);
//        //pq.add(x);
//        bq.add(x);
//        producerLatch.countDown();
//        //System.out.println(Thread.currentThread().getName()+"-LATCH REACH--"+producerLatch.getCount());
//    }
//}
//
//class Consumer implements Runnable {
//    //PriorityQueue pq;
//    private BlockingQueue bq;
//    private CountDownLatch ConsumerLatch;
//
//    public Consumer(BlockingQueue pq, CountDownLatch ConsumerLatch) {
//        //this.pq=pq;
//        this.bq = pq;
//        this.ConsumerLatch = ConsumerLatch;
//    }
//
//    public void run() {
//        //poll();
//        //int y = (int) pq.poll();
//        try {
//            int y = (int) bq.take();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ConsumerLatch.countDown();
//        //System.out.println(Thread.currentThread().getName()+"-LATCH REACH--"+ConsumerLatch.getCount());
//    }
//}
