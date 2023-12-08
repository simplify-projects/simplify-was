package was.apache.tomcat.coyote.http;

import java.io.InputStreamReader;

public interface RequestGenerator {

    Request generate(final InputStreamReader inputStreamReader);
}
