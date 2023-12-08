package was.apache.tomcat.coyote.http;

import java.util.List;
import java.util.Map;

public class Headers {

    private final Map<String, String> values;

    public Headers(Map<String, String> values) {
        this.values = values;
    }

    public Map<String, String> getValues() {
        return values;
    }
}
