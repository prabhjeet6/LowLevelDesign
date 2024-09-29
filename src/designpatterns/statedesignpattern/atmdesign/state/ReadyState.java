package designpatterns.statedesignpattern.atmdesign.state;

import designpatterns.statedesignpattern.atmdesign.dbaccessor.DBAccessor;
import designpatterns.statedesignpattern.atmdesign.model.ATM;
import designpatterns.statedesignpattern.atmdesign.model.CardDetails;

public class ReadyState implements State{

    private final ATM atm;
    public ReadyState(ATM atm){
        this.atm=atm;

    }
    @Override
    public int init() {
        int transactionId;
        transactionId= DBAccessor.createNewTransaction(this.atm.getMachineId());
        if(transactionId==0){
            throw new RuntimeException("Can not create Transaction");
        }
        this.atm.changeState(new CardReadingState(this.atm));
        return transactionId;
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        throw new IllegalStateException("Can not read card, Currently in Ready State");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Can not cancel transaction, Currently in Ready State");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Can not eject card, Currently in Ready State");
    }

    @Override
    public ATMState getATMState() {
        return ATMState.READY;
    }

    @Override
    public boolean readWithdrawlDetails(int transactionId, double amount, CardDetails cardDetails) {
        throw new IllegalStateException("Can not read withdrawal details , Currently in Ready State");
    }

    @Override
    public double dispenseCash(int transactionId, CardDetails cardDetails) {
        throw new IllegalStateException("Can not dispense cash , Currently in Ready State");
    }
}
