package designpatterns.statedesignpattern.atmdesign.model;

public interface CardManager {

    boolean validateCard(CardDetails cardDetails);

    boolean validateWithdrawal(double amount,
                               int transactionId);

    void executeWithdrawal(int transactionId);
}
