package designpatterns.chainofresponsibility.apihandlers.handler;

import designpatterns.chainofresponsibility.apihandlers.data.Request;

public interface RequestHandler {

        void handle(Request request);

}
