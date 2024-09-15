package designpatterns.chainofresponsibilitypattern.playvideoapi.handler;

import designpatterns.chainofresponsibilitypattern.playvideoapi.data.Request;

public interface RequestHandler {

        void handle(Request request);

}
