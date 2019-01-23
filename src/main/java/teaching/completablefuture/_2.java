//package teaching.completablefuture;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.*;
//
//public class _2 {
//
//    public static void main(String[] args) {
//
//        List<Integer> employeeIds = getEmployeeIds();
//        for (Integer id : employeeIds) {
//            CompletableFuture.supplyAsync(() -> new EmployeeFetcher(id))
//                    .thenApplyAsync(employee -> new TaxRateFetcher(employee))
//                    .thenApplyAsync(taxRate -> calculateTax(taxRate))
//                    .thenAcceptAsync(taxValue -> new SendEmail(taxValue));
//        }
//    }
//
//    private static BigDecimal calculateTax(Employee emp, TaxRate taxRate) {
//        return null;
//    }
//
//    public static List<Integer> getEmployeeIds() {
//        return new ArrayList<>();
//    }
//
//    static class EmployeeFetcher implements Callable<Employee> {
//        public EmployeeFetcher(Integer id) {
//
//        }
//
//        @Override
//        public Employee call() {
//            return new Employee();
//        }
//    }
//
//    private static class Employee {
//    }
//
//    private static class TaxRateFetcher implements Callable<TaxRate> {
//
//        public TaxRateFetcher(EmployeeFetcher emp) {
//
//        }
//
//        @Override
//        public TaxRate call() throws Exception {
//            return null;
//        }
//    }
//
//    private static class TaxRate {
//    }
//
//    private static class SendEmail implements Runnable {
//        public SendEmail(Employee emp, BigDecimal tax) {
//
//        }
//
//        @Override
//        public void run() {
//
//        }
//    }
//}
