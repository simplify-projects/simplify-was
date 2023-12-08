package was.apache.tomcat.coyote.http;

import java.net.Socket;

public interface Processor {

    void start(final Socket conn);
}
