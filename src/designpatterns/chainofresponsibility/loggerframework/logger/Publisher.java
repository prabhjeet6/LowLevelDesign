package designpatterns.chainofresponsibility.loggerframework.logger;

import java.util.concurrent.Flow;

public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notify(String message);
}
