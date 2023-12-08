package was.apache.tomcat.coyote.http;

import java.util.Arrays;
import java.util.Map;

import static java.util.Collections.EMPTY_MAP;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

public class Body {

    private static final String SEPARATOR = "&";
    private static final String DELIMITER = "=";
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private final Map<String, String> values;

    public Body(Map<String, String> values) {
        this.values = values;
    }

    public static Body from(final String body) {
        if (body == null) {
            return new Body(EMPTY_MAP);
        }
        return Arrays.stream(body.split(SEPARATOR))
                .map(element -> element.split(DELIMITER))
                .collect(collectingAndThen(
                        toMap(element -> element[KEY_INDEX], element -> element[VALUE_INDEX]),
                        Body::new
                ));
    }
    public Map<String, String> getValues() {
        return values;
    }
}
