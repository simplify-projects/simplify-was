package was.apache.coyote.http11;

import was.apache.coyote.Processor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Http11Processor implements Runnable, Processor {

    private final Socket conn;

    public Http11Processor(Socket conn) {
        this.conn = conn;
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

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
