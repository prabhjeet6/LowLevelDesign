package designpatterns.chainofresponsibility.playvideoapi.handler;

import designpatterns.chainofresponsibility.playvideoapi.data.Request;

public interface RequestHandler {

        void handle(Request request);

}
