package designpatterns.statedesignpattern.atmdesign.state;

import designpatterns.statedesignpattern.atmdesign.dbaccessor.DBAccessor;
import designpatterns.statedesignpattern.atmdesign.model.ATM;
import designpatterns.statedesignpattern.atmdesign.model.CardDetails;
import designpatterns.statedesignpattern.atmdesign.model.CardManagerFactory;
import designpatterns.statedesignpattern.atmdesign.model.TransactionStatus;

public class WithdrawalDetailsReadingState implements State{

    private final ATM atm;

    public WithdrawalDetailsReadingState(ATM atm) {
        this.atm=atm;
    }

    @Override
    public int init() {
        throw new IllegalStateException("Can not initiate transaction, Currently in   Withdrawal Details Reading State");
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        throw new IllegalStateException("Can not read card , Currently in   Withdrawal Details Reading State");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Can not cancel transaction, Currently in   Withdrawal Details Reading State");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Can not eject card, Currently in   Withdrawal Details Reading State");
    }

    @Override
    public ATMState getATMState() {
        return ATMState.WITHDRAWAL_DETAILS_READING;
    }

    @Override
    public boolean readWithdrawlDetails(int transactionId, double amount, CardDetails cardDetails) {
        //get CardManager from cardManagerFactory and validate withdrawal
        boolean result= CardManagerFactory.getCardManager(cardDetails.getCardType()).validateWithdrawal(amount,transactionId);
        // If validated, change state to withdrawal details reading state, otherwise go back to ready state
        if (result) {
            DBAccessor.persistWithDetails(transactionId, amount, TransactionStatus.NOT_APPROVED);
            this.atm.changeState(new CashDispensingState(this.atm));
        } else {
            DBAccessor.persistWithDetails(transactionId, amount, TransactionStatus.NOT_APPROVED);
            this.atm.changeState(new CardEjectingState(this.atm));
        }
        return true;
    }

    @Override
    public double dispenseCash(int transactionId,CardDetails cardDetails) {
        throw new IllegalStateException("Can not dispense cash , Currently in   Withdrawal Details Reading State");
    }
}
