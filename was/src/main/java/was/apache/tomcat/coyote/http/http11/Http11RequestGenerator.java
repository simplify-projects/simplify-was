package was.apache.tomcat.coyote.http.http11;

import was.apache.tomcat.coyote.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Http11RequestGenerator implements RequestGenerator {

    private static final String SEPARATOR = " ";
    private static final String HEADER_SEPARATOR = ": ";

    public Http11RequestGenerator() {
    }

    @Override
    public Request generate(final InputStreamReader inputStreamReader) {
        final BufferedReader br = new BufferedReader(inputStreamReader);
        return new Request(getRequestLine(br), getHeaders(br));
    }

    private RequestLine getRequestLine(final BufferedReader br) {
        final String requestLine;
        try {
            requestLine = br.readLine();
            final String[] requestLines = requestLine.split(SEPARATOR);

            final String method = requestLines[0];
            final String path = requestLines[1];
            final String protocol = requestLines[2];

            return new RequestLine(Method.from(method), Path.from(path), Protocol.from(protocol));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Headers getHeaders(final BufferedReader bufferedReader) {
        final Map<String, String> requestHeaders = new LinkedHashMap<>();
        try {
            for (String header = bufferedReader.readLine(); !"".equals(header); header = bufferedReader.readLine()) {
                String[] headers = header.split(HEADER_SEPARATOR);
                requestHeaders.put(headers[0], headers[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Headers(requestHeaders);
    }

}
