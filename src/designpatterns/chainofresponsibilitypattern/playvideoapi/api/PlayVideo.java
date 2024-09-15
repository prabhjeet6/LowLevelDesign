package designpatterns.chainofresponsibilitypattern.playvideoapi.api;

import designpatterns.chainofresponsibilitypattern.playvideoapi.data.Request;
import designpatterns.chainofresponsibilitypattern.playvideoapi.data.Response;
import designpatterns.chainofresponsibilitypattern.playvideoapi.handler.RequestHandlerFactory;

public class PlayVideo {
    public Response playVideo(Request request) {
        RequestHandlerFactory.getRequestHandler().handle(request);
        return null;
    }
}
