package designpatterns.chainofresponsibility.apihandlers.handler;


import designpatterns.chainofresponsibility.apihandlers.data.Request;

public class IdleHandler implements RequestHandler{
    @Override
    public void handle(Request request) {
        System.out.println("All done");
    }
}
