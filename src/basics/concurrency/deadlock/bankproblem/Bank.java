package basics.concurrency.deadlock.bankproblem;

import deadlocks.bankingProblem.Account;

public class Bank {
    public void transfer(Account source, Account destination, int amount) {
        Account account1, account2;
        if (source.getId() < destination.getId()) {
            account1 = source;
            account2 = destination;
        } else {
            account2 = source;
            account1 = destination;
        }
        synchronized (account1) {
            synchronized (account2) {
                /*
                //This will also work, because, locks are anyway correctly setup,
                //hence, we can simply deduct on source and add to destination
                 * source.deduct(amount);
                 * destination.add(amount);*/

                account1.deduct(amount);
                account2.add(amount);
            }
        }
    }
}
