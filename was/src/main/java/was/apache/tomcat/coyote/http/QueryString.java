package was.apache.tomcat.coyote.http;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.EMPTY_MAP;

/* VO */
public class QueryString {

    private static final String QUERY_STRING_SEPARATOR = "\\&";
    private static String QUERY_STRING_KEY_VALUE_SEPARATOR = "=";

    private final Map<String, String> values;

    public QueryString(final Map<String, String> values) {
        this.values = values;
    }

    public static QueryString from(final String queryString) {
        if (queryString == null) {
            return new QueryString(EMPTY_MAP);
        }
        return new QueryString(getQueryStringPairs(queryString));
    }

    private static Map<String, String> getQueryStringPairs(final String queryString) {
        List<String> queryStringKeyAndValue = Arrays.asList(queryString.split(QUERY_STRING_SEPARATOR));
        return queryStringKeyAndValue.stream()
                .map(keyValuePair -> keyValuePair.split(QUERY_STRING_KEY_VALUE_SEPARATOR))
                .collect(Collectors.toMap(parts -> parts[0], parts -> parts[1]));
    }

    public Map<String, String> getValues() {
        return values;
    }

}
