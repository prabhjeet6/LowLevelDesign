package designpatterns.observerpattern.publishers;


import designpatterns.observerpattern.subscribers.CricketSubscriber;

public interface CricketPublisher {

    void subscribe(CricketSubscriber subscriber);
    void unsubscribe(CricketSubscriber subscriber);
    void notifyAll(int runs, int wickets, float overs);
    int getRuns();
    float getOvers();
    int getWickets();

}
