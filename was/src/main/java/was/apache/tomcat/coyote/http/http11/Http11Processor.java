package was.apache.tomcat.coyote.http.http11;

import was.apache.tomcat.coyote.http.Request;
import was.apache.tomcat.coyote.http.RequestGenerator;
import was.apache.tomcat.coyote.http.Processor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Http11Processor implements Runnable, Processor {

    private final Socket conn;
    private final RequestGenerator requestGenerator;

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
            Request request = requestGenerator.generate(new InputStreamReader(inputStream));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
