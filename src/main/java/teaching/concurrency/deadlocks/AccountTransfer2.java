package teaching.concurrency.deadlocks;

import java.math.BigDecimal;

public class AccountTransfer2 {

    private void transfer(Account from, Account to, BigDecimal amount) {

        Account acc1 = getLarger(from, to);
        Account acc2 = getSmaller(from, to);

        synchronized (acc1) {
            synchronized (acc2) {
                from.deduct(amount);
                to.add(amount);
            }
        }
    }

    private Account getLarger(Account from, Account to) {
        return null;
    }

    private Account getSmaller(Account from, Account to) {
        return null;
    }

    private class Account {
        public int number;

        public void add(BigDecimal amount) {

        }

        public void deduct(BigDecimal amount) {

        }
    }
}
