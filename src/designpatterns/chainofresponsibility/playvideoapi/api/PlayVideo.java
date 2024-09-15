package designpatterns.chainofresponsibility.playvideoapi.api;

import designpatterns.chainofresponsibility.playvideoapi.data.Request;
import designpatterns.chainofresponsibility.playvideoapi.data.Response;
import designpatterns.chainofresponsibility.playvideoapi.handler.RequestHandlerFactory;

public class PlayVideo {
    public Response playVideo(Request request) {
        RequestHandlerFactory.getRequestHandler().handle(request);
        return null;
    }
}
