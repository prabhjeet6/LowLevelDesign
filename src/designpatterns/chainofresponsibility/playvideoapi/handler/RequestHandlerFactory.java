package designpatterns.chainofresponsibility.playvideoapi.handler;


import designpatterns.chainofresponsibility.playvideoapi.manager.TokenManager;

public class RequestHandlerFactory {
    private RequestHandlerFactory(){

    }
    public static RequestHandler getRequestHandler(){

        AuthorizationHandler authorizationHandler=new AuthorizationHandler(
                new IdleHandler(), new UserManager());
        AuthenticationHandler authenticationHandler=
                new AuthenticationHandler(authorizationHandler,new TokenManager());
        return new ValidationHandler(authenticationHandler);
    }
}
