package basics.concurrency.deadlock.bankproblem;

import deadlocks.bankingProblem.Account;

public class Worker implements Runnable {

    private final Account source, destination;
    private final Bank bank;
    private final int amount;

    public Worker(Account source, Account destination, Bank bank, int amount) {
        this.source = source;
        this.destination = destination;
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {
        this.bank.transfer(source, destination, amount);
    }
}
