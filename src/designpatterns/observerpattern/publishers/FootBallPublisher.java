package designpatterns.observerpattern.publishers;


import designpatterns.observerpattern.subscribers.FootBallSubscriber;

public interface FootBallPublisher {

    void subscribe(FootBallSubscriber subscriber);
    void unsubscribe(FootBallSubscriber subscriber);
    void notifyAll(int goals1, int goals2, float duration);
    int getGoals1();
    int getGoals2();
    float getDuration();

}
