package designpatterns.chainofresponsibility.playvideoapi.handler;


import designpatterns.chainofresponsibility.playvideoapi.data.Request;

public class IdleHandler implements RequestHandler{
    @Override
    public void handle(Request request) {
        System.out.println("All done");
    }
}
