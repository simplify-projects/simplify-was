package was.apache.tomcat.coyote;

import java.net.Socket;

public interface Processor {

    void start(final Socket conn);
}
