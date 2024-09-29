package designpatterns.statedesignpattern.atmdesign.api;

import designpatterns.statedesignpattern.atmdesign.model.ATM;
import designpatterns.statedesignpattern.atmdesign.model.CardDetails;
import designpatterns.statedesignpattern.atmdesign.model.CardType;

public class ReadCardAPI {
    public boolean readCard(CardType cardType, long cardNumber, int pin, String name, String machineId) {
        CardDetails cardDetails = new CardDetails(cardType, cardNumber, pin, name);
        ATM atm = new ATM(machineId);
        return atm.readCard(cardDetails);
    }
}
