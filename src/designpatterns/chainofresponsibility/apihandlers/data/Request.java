package designpatterns.chainofresponsibility.apihandlers.data;

public class Request {
    private final String header;
    private final String body;
    private final String token;

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public String getToken() {
        return token;
    }

    public Request(String header, String body, String token) {
        this.header = header;
        this.body = body;
        this.token = token;
    }
}
