package was.apache.tomcat.coyote.http11;

import was.apache.tomcat.coyote.HttpRequest;
import was.apache.tomcat.coyote.HttpRequestGenerator;
import was.apache.tomcat.coyote.Processor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Http11Processor implements Runnable, Processor {

    private final Socket conn;
    private final HttpRequestGenerator requestGenerator;

    public Http11Processor(Socket conn) {
        this.conn = conn;
        this.requestGenerator = new Http11RequestGenerator();
    }

    @Override
    public void run() {
        start(conn);
    }

    @Override
    public void start(final Socket conn) {
        try (
                final InputStream inputStream = conn.getInputStream();
                final OutputStream outputStream = conn.getOutputStream();
        ) {
            HttpRequest httpRequest = requestGenerator.generate(new InputStreamReader(inputStream));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
