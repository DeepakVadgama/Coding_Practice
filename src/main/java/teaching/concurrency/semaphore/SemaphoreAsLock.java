//package teaching.concurrency.semaphore;
//
//import java.util.concurrent.Semaphore;
//
//public class SemaphoreAsLock {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        Semaphore semaphore = new Semaphore(1);
//    }
//
//    static class TaskByThread1 implements Runnable {
//
//        @Override
//        public void run() {
//
//            semaphore.acquireUninterruptibly();
//            // IO call to the slow service
//            semaphore.release();
//            
//            // rest of processing
//        }
//
//        private final Semaphore semaphore;
//
//        public Task(Semaphore semaphore) {
//            this.semaphore = semaphore;
//        }
//
//    }
//}
