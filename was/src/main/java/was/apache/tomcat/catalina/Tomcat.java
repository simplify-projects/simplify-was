package was.apache.tomcat.catalina;

import java.io.IOException;

public class Tomcat implements WebApplicationServer {

    @Override
    public void boot() {
        final Connector connector = new Connector();
        connector.start();

        try {
            // make the application wait until we press any key.
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connector.stop();
        }
    }

}
