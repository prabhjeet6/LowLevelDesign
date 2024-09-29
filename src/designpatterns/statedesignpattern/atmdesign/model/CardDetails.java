package designpatterns.statedesignpattern.atmdesign.model;

public class CardDetails {

    private  final CardType cardType;
    private final long cardNumber;
    private final int pin;
    private final String userName;

    public CardDetails(CardType cardType, long cardNumber, int pin, String userName) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.userName = userName;
    }

    public   CardType getCardType() {
        return cardType;
    }

    public long getCardNumber() { return cardNumber; }

    public int getPin() {
        return pin;
    }

    public String getUserName() {
        return userName;
    }

}
