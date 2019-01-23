package teaching.concurrency.deadlocks;

import java.math.BigDecimal;

public class AccountTransfer {

    private void transfer(Account acc1, Account acc2, BigDecimal amount) {

        synchronized (acc1) {
            synchronized (acc2) {
                acc1.deduct(amount);
                acc2.add(amount);
            }
        }
    }

    private class Account {
        public void add(BigDecimal amount) {

        }

        public void deduct(BigDecimal amount) {

        }
    }
}
