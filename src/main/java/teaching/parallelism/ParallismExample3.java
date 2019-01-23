//package teaching.parallelism;
//
//import teaching.lambda.User;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ParallismExample3 {
//
//    private static User user2;
//    private static User user1;
//
//    public static void main(String[] args) {
//
//        ExecutorService es = Executors.newFixedThreadPool(4);
//        es.submit(() -> processTax(user1));
//        es.submit(() -> processTax(user2));
//
//        heavyCalculations();
//    }
//
//    private static void processTax(User user1) {
//
//    }
//
//    private static void heavyCalculations() {
//
//    }
//}
