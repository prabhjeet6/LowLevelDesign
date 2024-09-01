package designpatterns.observerpattern.subscribers;


import designpatterns.observerpattern.publishers.CricketPublisher;
import designpatterns.observerpattern.publishers.FootBallPublisher;

import java.util.List;

public class PredictedScoreSubscriber implements CricketSubscriber,
        FootBallSubscriber {

    private int runs;
    private int wickets;
    private float overs;
    private int goals1;
    private int goals2;
    private float duration;
    private List<CricketPublisher> cricketPublishers;
    private List<FootBallPublisher> footBallPublishers;


    public PredictedScoreSubscriber(List<?> publishers) {
        if (publishers.getFirst() instanceof CricketPublisher) {
            for (CricketPublisher cricketPublisher : this.cricketPublishers)
                cricketPublisher.subscribe(this);
        } else {

            for (FootBallPublisher footBallPublisher : this.footBallPublishers)
                footBallPublisher.subscribe(this);
        }

    }


    @Override
    public void update(CricketPublisher publisher) {
        this.runs = publisher.getRuns();
        this.wickets = publisher.getWickets();
        this.overs = publisher.getOvers();

        // additional logic
        System.out.println("In ProjectedScoreSubscriber : " + this.runs + " runs," + this.wickets + " wickets,"
                + this.overs + " overs.");
    }

    @Override
    public void update(FootBallPublisher publisher) {

    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public float getOvers() {
        return overs;
    }

    public List<CricketPublisher> getCricketPublishers() {
        return cricketPublishers;
    }
    public List<FootBallPublisher> getFootBallPublishers() {
        return footBallPublishers;
    }
}