package was.apache.tomcat.coyote.http;

public class RequestLine {

    private final Method method;
    private final Path path;
    private final Protocol protocol;

    public RequestLine(Method method, Path path, Protocol protocol) {
        this.method = method;
        this.path = path;
        this.protocol = protocol;
    }

    public Method getMethod() {
        return method;
    }

    public Path getPath() {
        return path;
    }

    public Protocol getProtocol() {
        return protocol;
    }
}
