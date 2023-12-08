package was.apache.tomcat.coyote;

import java.io.InputStreamReader;

public interface HttpRequestGenerator {

    HttpRequest generate(final InputStreamReader inputStreamReader);
}
