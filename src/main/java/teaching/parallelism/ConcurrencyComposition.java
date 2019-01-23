//package teaching.parallelism;
//
//import teaching.lambda.Tax;
//import teaching.lambda.User;
//
//import java.math.BigDecimal;
//
//@SuppressWarnings("all")
//public class ConcurrencyComposition {
//
//    private static int ticketsAvailable = 2;
//
//    public static void main(String[] args) throws InterruptedException {
//
//        User user = fetchUserFromDB();
//
//        Tax taxRate = fetchGovtTaxRate();
//
//        BigDecimal tax = calculateTax();
//
//        saveTaxInDB(user, tax);
//    }
//
//    private static void saveTaxInDB(User user, BigDecimal tax) {
//        
//    }
//
//    private static BigDecimal calculateTax() {
//        return null;
//    }
//
//    private static Tax fetchGovtTaxRate() {
//        return null;
//    }
//
//    private static User fetchUserFromDB() {
//        return null;
//    }
//
//    private static void bookTicket() {
//
//    }
//}
