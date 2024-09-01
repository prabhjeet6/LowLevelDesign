package designpatterns.observerpattern.subscribers;


import designpatterns.observerpattern.publishers.FootBallPublisher;

public interface FootBallSubscriber {

    void update(FootBallPublisher publisher);

}
