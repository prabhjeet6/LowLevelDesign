package designpatterns.statedesignpattern.atmdesign.api;

import designpatterns.statedesignpattern.atmdesign.model.ATM;

public class InitiateTransactionAPI {
    public int initiateTransaction(String machineId) {
        if (machineId == null || machineId.isEmpty())
            throw new IllegalArgumentException("machineId can't be null or empty");
        ATM atm = new ATM(machineId);
        return atm.init();
    }
}
