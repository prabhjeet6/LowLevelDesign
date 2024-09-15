package designpatterns.chainofresponsibilitypattern.playvideoapi.handler;


import designpatterns.chainofresponsibilitypattern.playvideoapi.data.Request;

public class IdleHandler implements RequestHandler{
    @Override
    public void handle(Request request) {
        System.out.println("All done");
    }
}
