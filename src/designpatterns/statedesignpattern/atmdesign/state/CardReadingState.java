package designpatterns.statedesignpattern.atmdesign.state;

import designpatterns.statedesignpattern.atmdesign.dbaccessor.DBAccessor;
import designpatterns.statedesignpattern.atmdesign.model.ATM;
import designpatterns.statedesignpattern.atmdesign.model.CardDetails;
import designpatterns.statedesignpattern.atmdesign.model.CardManagerFactory;

public class CardReadingState implements State{

    private final ATM atm;


    public CardReadingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int init() {
        throw new IllegalStateException("Can not initiate transaction, Currently in Card Reading  State");
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        //get CardManager from cardManagerFactory and validate card
        boolean result= CardManagerFactory.getCardManager(cardDetails.getCardType()).validateCard(cardDetails);
        // Persist card swipe at this particular ATM machine
        DBAccessor.persistCardDetails(cardDetails,
                this.atm.getMachineId());
        // If validated, change state to withdrawal details reading state, otherwise go back to ready state
        if (result) {
            this.atm.changeState(new WithdrawalDetailsReadingState(this.atm));
        } else {
            DBAccessor.disapproveTransaction(this.atm.getMachineId());
            this.atm.changeState(new ReadyState(this.atm));
        }
        return true;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Can not cancel transaction, Currently in Card Reading  State");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Can not eject card, Currently in Card Reading  State");
    }

    @Override
    public ATMState getATMState() {
        return ATMState.CARD_READING;
    }

    @Override
    public boolean readWithdrawlDetails(int transactionId, double amount, CardDetails cardDetails) {
        throw new IllegalStateException("Can not read withdrawal state , Currently in Card Reading  State");
    }

    @Override
    public double dispenseCash(int transactionId,CardDetails cardDetails) {
        throw new IllegalStateException("Can not dispense cash, Currently in Card Reading  State");
    }
}
