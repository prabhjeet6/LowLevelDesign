package designpatterns.chainofresponsibility.apihandlers.handler;

import designpatterns.chainofresponsibility.apihandlers.data.Request;

public class AuthorizationHandler implements RequestHandler{
    private final RequestHandler nextHandler;

    private final UserManager userManager;

    public AuthorizationHandler(RequestHandler nextHandler,
                                UserManager userManager) {
        this.nextHandler = nextHandler;
        this.userManager = userManager;
    }
    @Override
    public void handle(Request request) {
        if (!this.userManager.isSubscribed(request.getToken())) {
            throw new RuntimeException("Authorization failed");
        }
        System.out.println("Authorisation passed");
        this.nextHandler.handle(request);
    }
}
