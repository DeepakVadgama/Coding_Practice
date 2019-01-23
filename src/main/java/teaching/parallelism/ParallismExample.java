//package teaching.parallelism;
//
//import teaching.lambda.User;
//
//public class ParallismExample {
//
//    private static User user2;
//    private static User user1;
//
//    public static void main(String[] args) {
//
//        new Thread(() -> {
//            processTax(user1);
//        }).start();
//
//        new Thread(() -> {
//            processTax(user2);
//        }).start();
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
