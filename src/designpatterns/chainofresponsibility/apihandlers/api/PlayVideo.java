package designpatterns.chainofresponsibility.apihandlers.api;

import designpatterns.chainofresponsibility.apihandlers.data.Request;
import designpatterns.chainofresponsibility.apihandlers.data.Response;
import designpatterns.chainofresponsibility.apihandlers.handler.RequestHandlerFactory;

public class PlayVideo {
    public Response playVideo(Request request) {
        RequestHandlerFactory.getRequestHandler().handle(request);
        return null;
    }
}
