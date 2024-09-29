package designpatterns.statedesignpattern.atmdesign.state;

import designpatterns.statedesignpattern.atmdesign.dbaccessor.DBAccessor;
import designpatterns.statedesignpattern.atmdesign.model.CardDetails;
import designpatterns.statedesignpattern.atmdesign.model.CardManagerFactory;
import designpatterns.statedesignpattern.atmdesign.model.ATM;

public class CashDispensingState implements State {
    private final ATM atm;

    public CashDispensingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int init() {
        throw new IllegalStateException("Can not initiate transaction , Currently in   Card Dispensing   State");
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        throw new IllegalStateException("Can not read card , Currently in   Card Dispensing   State");

    }

    @Override
    public boolean cancelTransaction(int transId) {
        DBAccessor.cancelTransaction(transId);
        this.atm.changeState(new CardEjectingState(this.atm));
        return true;
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Can not eject card , Currently in   Card Dispensing   State");

    }

    @Override
    public ATMState getATMState() {
        return ATMState.CASH_DISPENSING;
    }

    @Override
    public boolean readWithdrawlDetails(int transactionId, double amount, CardDetails cardDetails) {
        throw new IllegalStateException("Can not read withdrawal details , Currently in   Card Dispensing   State");

    }

    @Override
    public double dispenseCash(int transactionId, CardDetails cardDetails) {
        CardManagerFactory.getCardManager(cardDetails.getCardType()).executeWithdrawal(transactionId);
        this.atm.changeState(new CardEjectingState(this.atm));
        return DBAccessor.markAsExecuted(transactionId);
    }
}
