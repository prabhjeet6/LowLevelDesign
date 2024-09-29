package designpatterns.statedesignpattern.atmdesign.dbaccessor;


import designpatterns.statedesignpattern.atmdesign.model.CardDetails;
import designpatterns.statedesignpattern.atmdesign.model.TransactionStatus;
import designpatterns.statedesignpattern.atmdesign.state.ATMState;

public class DBAccessor {

    private DBAccessor() {}

    public static ATMState getATMState(String machineId) {
        return ATMState.READY;
    }

    public static int createNewTransaction(String machineId) {
        return 1;
    }

    public static void updateATMState(String machineId, ATMState state) {

    }

    public static void persistCardDetails(CardDetails cardDetails, String machineId) {

    }

    public static void disapproveTransaction(String machineId) {

    }

    public static void cancelTransaction(int transId) {

    }

    public static void persistWithDetails(int transId, double amount, TransactionStatus status) {

    }

    public static float markAsExecuted(int transId) {return 0;}

}