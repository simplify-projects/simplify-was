package was.apache.tomcat.coyote.http;

public class Request {

    private final Method method;
    private final Path path;
    private final Protocol protocol;
    private final Headers headers;

    public Request(Method method, Path path, Protocol protocol, Headers headers) {
        this.method = method;
        this.path = path;
        this.protocol = protocol;
        this.headers = headers;
    }

    public Method getMethod() {
        return method;
    }

    public Path getPath() {
        return path;
    }

    public Headers getHeaders() {
        return headers;
    }
}
