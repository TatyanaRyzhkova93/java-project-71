package hexlet.code.formatters;

public class FormatFactory {
    private static final String FORMAT_PLANE = "plane";
    private static final String FORMAT_JSON = "json";

    public Format getFormat(String name) {
        if (name.equalsIgnoreCase(FORMAT_PLANE)) {
            return new Plane();
        } else if (name.equalsIgnoreCase(FORMAT_JSON)) {
            return new JsonFormatter();
        }
        return new Stylish();
    }
}

