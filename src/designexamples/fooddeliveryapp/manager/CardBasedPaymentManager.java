package designexamples.fooddeliveryapp.manager;

import designexamples.fooddeliveryapp.data.PaymentResponse;

public class CardBasedPaymentManager implements PaymentManager {
    private final String bankName;
    private final String cardNumber;
    private final double amount;
    private final String pin;

    public CardBasedPaymentManager(String bankName, String cardNumber, String pin, double amount) {
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.pin = pin; //transactionId
        this.amount = amount;
    }

    @Override
    public PaymentResponse executePayment() {
        // here, instance variables should be encrypted,
        // Depending upon the response of payment gateway, we deduce if the payment was successful

        return null;
    }
}
