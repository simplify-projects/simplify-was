package was.apache.tomcat.coyote;

import java.util.Arrays;

public enum Protocol {

    HTTP1("HTTP/1.0"),
    HTTP11("HTTP/1.1"),
    HTTP2("HTTP/2.0"),
    ;

    private final String value;

    Protocol(String value) {
        this.value = value;
    }

    public static Protocol from(final String protocol) {
        return Arrays.stream(values())
                .filter(value -> protocol.equals(value.getValue()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(protocol + "는 존재하지 않는 프로토콜입니다."));
    }

    public String getValue() {
        return value;
    }
}
