package designpatterns.statedesignpattern.atmdesign.state;

public enum ATMState {
    READY,
    CARD_READING,
    WITHDRAWAL_DETAILS_READING,
    CASH_DISPENSING,
    CARD_EJECTING

}
