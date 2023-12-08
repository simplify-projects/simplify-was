package was.apache.tomcat.coyote.http;

import java.util.Arrays;

public enum Method {

    GET,
    POST,
    PUT,
    PATCH,
    DELETE,
    ;

    public static Method from(final String method) {
        return Arrays.stream(Method.values())
                .filter(value -> method.equals(value.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 HttpMethod입니다."));

    }
}
