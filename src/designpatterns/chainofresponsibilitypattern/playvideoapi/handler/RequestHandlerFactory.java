package designpatterns.chainofresponsibilitypattern.playvideoapi.handler;


import designpatterns.chainofresponsibilitypattern.playvideoapi.manager.TokenManager;

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
