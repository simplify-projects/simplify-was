package was.apache.tomcat.coyote.http;

public class Path {
    private static final String PATH_SEPARATOR = "\\?";
    private static final Integer DEFAULT_PATH_INDEX = 0;
    private static final Integer QUERY_STRING_PATH_INDEX = 1;

    private final DefaultPath defaultPath;
    private final QueryString queryString;

    public Path(DefaultPath defaultPath, QueryString queryString) {
        this.defaultPath = defaultPath;
        this.queryString = queryString;
    }

    public static Path from(final String path) {
        String[] separatedPath = path.split(PATH_SEPARATOR);
        DefaultPath defaultPath = new DefaultPath(separatedPath[DEFAULT_PATH_INDEX]);
        Path appendedPath = existQueryString(separatedPath, defaultPath);
        if (appendedPath != null) return appendedPath;
        return new Path(defaultPath, null);
    }

    private static Path existQueryString(String[] separatedPath, DefaultPath defaultPath) {
        if (separatedPath.length > 1) {
            QueryString queryString = QueryString.from(separatedPath[QUERY_STRING_PATH_INDEX]);
            return new Path(defaultPath, queryString);
        }
        return null;
    }

    public DefaultPath getDefaultPath() {
        return defaultPath;
    }

    public QueryString getQueryString() {
        return queryString;
    }

}
