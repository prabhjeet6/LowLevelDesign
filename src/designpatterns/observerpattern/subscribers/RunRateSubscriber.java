package designpatterns.observerpattern.subscribers;


import designpatterns.observerpattern.publishers.CricketPublisher;

public class RunRateSubscriber implements CricketSubscriber {

    private int runs;
    private float overs;
    private final CricketPublisher publisher;



    public RunRateSubscriber(CricketPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void update(CricketPublisher publisher) {
        this.runs = publisher.getRuns();
        this.overs = publisher.getOvers();
        // additional logic
        System.out.println("In RunrateSubscriber : " + this.runs + " runs," +
                + this.overs + " overs.");
    }

    public int getRuns() {
        return runs;
    }

    public float getOvers() {
        return overs;
    }

    public CricketPublisher getPublisher() {
        return publisher;
    }
}
