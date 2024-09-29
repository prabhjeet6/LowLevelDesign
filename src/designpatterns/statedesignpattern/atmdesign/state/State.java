package designpatterns.statedesignpattern.atmdesign.state;

import designpatterns.statedesignpattern.atmdesign.model.CardDetails;

public interface State {
    int init();
    boolean readCard(CardDetails cardDetails);
    boolean cancelTransaction(int transactionId);
    void ejectCard();
    ATMState getATMState();
    boolean readWithdrawlDetails(int transactionId,double amount, CardDetails cardDetails);
    double dispenseCash(int transactionId, CardDetails cardDetails);

}
