package was.apache.tomcat.coyote;

public class HttpRequest {

    private final Method method;
    private final Path path;
    private final Protocol protocol;
    private final Headers headers;

    public HttpRequest(Method method, Path path, Protocol protocol, Headers headers) {
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
