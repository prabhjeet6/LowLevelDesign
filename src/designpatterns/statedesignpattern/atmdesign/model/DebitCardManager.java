package designpatterns.statedesignpattern.atmdesign.model;


public class DebitCardManager implements CardManager{
    @Override
    public boolean validateCard(CardDetails cardDetails) {
        return false;
    }

    @Override
    public boolean validateWithdrawal(double amount, int transId) {
        return false;
    }

    @Override
    public void executeWithdrawal(int transId) {

    }
}
