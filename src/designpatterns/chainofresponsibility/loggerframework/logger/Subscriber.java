package designpatterns.chainofresponsibility.loggerframework.logger;

public interface Subscriber {
    void update(String message);
}
