package designpatterns.statedesignpattern.atmdesign.state;

import designpatterns.statedesignpattern.atmdesign.model.ATM;
import designpatterns.statedesignpattern.atmdesign.model.CardDetails;

public class CardEjectingState implements State{
    private final ATM atm;

    public CardEjectingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int init() {
        throw new IllegalStateException("Can not initiate transaction , Currently in   Card Ejecting   State");
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        throw new IllegalStateException("Can not read card , Currently in   Card Ejecting   State");

    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Can not cancel transaction , Currently in   Card Ejecting   State");
    }

    @Override
    public void ejectCard() {
        this.atm.changeState(new ReadyState(this.atm));
    }

    @Override
    public ATMState getATMState() {
        return ATMState.CARD_EJECTING;
    }

    @Override
    public boolean readWithdrawlDetails(int transactionId, double amount, CardDetails cardDetails) {
        return false;
    }

    @Override
    public double dispenseCash(int transactionId, CardDetails cardDetails) {

        throw new IllegalStateException();
    }
}
