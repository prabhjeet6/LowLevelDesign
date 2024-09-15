package designpatterns.chainofresponsibilitypattern.loggerframework.logger;

public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notify(String message);
}
