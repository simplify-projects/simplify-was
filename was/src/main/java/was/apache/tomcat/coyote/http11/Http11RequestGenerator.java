package was.apache.tomcat.coyote.http11;

import was.apache.tomcat.coyote.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Http11RequestGenerator implements HttpRequestGenerator {

    private static final String SEPARATOR = " ";
    private static final String HEADER_SEPARATOR = ": ";

    public Http11RequestGenerator() {
    }

    @Override
    public HttpRequest generate(final InputStreamReader inputStreamReader) {
        final BufferedReader br = new BufferedReader(inputStreamReader);
        try {
            final String requestLine = br.readLine();
            final String[] requestLines = requestLine.split(SEPARATOR);

            final String method = requestLines[0];
            final String path = requestLines[1];
            final String protocol = requestLines[2];

            return new HttpRequest(Method.from(method), Path.from(path), Protocol.from(protocol), getHeaders(br));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Headers getHeaders(final BufferedReader bufferedReader) throws IOException {
        Map<String, String> requestHeaders = new LinkedHashMap<>();
        for (String header = bufferedReader.readLine(); !"".equals(header); header = bufferedReader.readLine()) {
            String[] headers = header.split(HEADER_SEPARATOR);
            requestHeaders.put(headers[0], headers[1]);
        }
        return new Headers(requestHeaders);
    }

}
