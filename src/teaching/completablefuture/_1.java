//package teaching.completablefuture;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.concurrent.*;
//
//public class _1 {
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        ExecutorService service = Executors.newFixedThreadPool(10);
//
//        List<Integer> employeeIds = getEmployeeIds();
//        for (Integer id : employeeIds) {
//
//            // Step 1: Fetch Employee details from DB
//            Future<Employee> future = service.submit(new EmployeeFetcher(id));
//            Employee emp = future.get(); // blocking
//
//            // Step 2: Fetch Employee tax rate from REST service
//            Future<TaxRate> rateFuture = service.submit(new TaxRateFetcher(emp));
//            TaxRate taxRate = rateFuture.get(); // blocking
//
//            // Step 3: Calculate current year tax
//            BigDecimal tax = calculateTax(emp, taxRate);
//
//            // Step 4: Send email to employee using REST service
//            service.submit(new SendEmail(emp, tax));
//        }
//    }
//
//    private static BigDecimal calculateTax(Employee emp, TaxRate taxRate) {
//        return null;
//    }
//
//    public static List<Integer> getEmployeeIds() {
//        return employeeIds;
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
//        public TaxRateFetcher(Employee emp) {
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
