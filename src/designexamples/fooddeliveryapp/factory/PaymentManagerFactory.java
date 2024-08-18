package designexamples.fooddeliveryapp.factory;

import designexamples.fooddeliveryapp.data.PaymentMode;
import designexamples.fooddeliveryapp.exception.FoodDileveryAppException;
import designexamples.fooddeliveryapp.manager.CardBasedPaymentManager;
import designexamples.fooddeliveryapp.manager.NetBankingPaymentManager;
import designexamples.fooddeliveryapp.manager.PaymentManager;

import java.util.Map;

public class PaymentManagerFactory {

    private PaymentManagerFactory() {}
    static PaymentManager paymentManager ;
    public static PaymentManager getPaymentManager(Enum<PaymentMode> paymentMode,
                                                   Map<String, String> paymentInfo) throws FoodDileveryAppException {

        if (paymentMode.equals(PaymentMode.NET_BANKING))
            paymentManager = getNetBankingPaymentManager(paymentInfo);
        else if (paymentMode.equals(PaymentMode.CARD))
            paymentManager = getCardBasedPaymentManager(paymentInfo);
        else
            throw new FoodDileveryAppException("Invalid paymentMode");
        return paymentManager;
    }

    //PaymentManager Data returned should be Encrypted
    private static PaymentManager getNetBankingPaymentManager(Map<String, String> paymentInfo) {
        return new NetBankingPaymentManager(paymentInfo.get("bankName"), paymentInfo.get("userName"),
                paymentInfo.get("passWord"), paymentInfo.get("pin"), Double.parseDouble(paymentInfo.get("amount")));
    }

    private static PaymentManager getCardBasedPaymentManager(Map<String, String> paymentInfo) {
        return new CardBasedPaymentManager(paymentInfo.get("bankName"), paymentInfo.get("cardNumber"),
                paymentInfo.get("pin"), Double.parseDouble(paymentInfo.get("amount")));
    }


}
