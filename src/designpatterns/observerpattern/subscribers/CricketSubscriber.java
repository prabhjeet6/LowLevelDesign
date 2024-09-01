package designpatterns.observerpattern.subscribers;


import designpatterns.observerpattern.publishers.CricketPublisher;

public interface CricketSubscriber {

    void update(CricketPublisher publisher);


}
