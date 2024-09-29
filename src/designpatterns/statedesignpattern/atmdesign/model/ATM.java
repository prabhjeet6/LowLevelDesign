package designpatterns.statedesignpattern.atmdesign.model;


import designpatterns.statedesignpattern.atmdesign.dbaccessor.DBAccessor;
import designpatterns.statedesignpattern.atmdesign.state.State;
import designpatterns.statedesignpattern.atmdesign.state.StateFactory;

public class ATM {

    private State state;
    private final String machineId;

    public ATM(String machineId) {
        this.machineId = machineId;
        this.state = StateFactory.getState(DBAccessor.getATMState(this.machineId), this);
    }

    public int init() {
        int id = this.state.init();
        return id;
    }

    public boolean cancel(int transId) {
        return this.state.cancelTransaction(transId);
    }

    public boolean readCard(CardDetails cardDetails) {
        return this.state.readCard(cardDetails);
    }

    public boolean readWithdrawalDetails(CardDetails cardDetails, int transId, double amount) {
        return this.state.readWithdrawlDetails( transId, amount,cardDetails);
    }

    public double dispenseCash(int transId,CardDetails cardDetails) {
        return this.state.dispenseCash(transId,cardDetails);
    }

    public void ejectCard() {
        this.state.ejectCard();
    }

    public State getState() {
        return state;
    }

    public String getMachineId() {
        return machineId;
    }

    public void changeState(State newState) {
        this.state = newState;
        DBAccessor.updateATMState(this.getMachineId(), newState.getATMState());
    }
}