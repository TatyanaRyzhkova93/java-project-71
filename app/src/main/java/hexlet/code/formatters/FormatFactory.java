package hexlet.code.formatters;

import static hexlet.code.Differ.FORMAT_PLAIN;

public class FormatFactory {
    private static final String FORMAT_JSON = "json";

    public static Format getFormat(String name) {
        if (name != null && name.equalsIgnoreCase(FORMAT_PLAIN)) {
            return new Plain();
        } else if (name != null && name.equalsIgnoreCase(FORMAT_JSON)) {
            return new JsonFormatter();
        }
        return new Stylish();
    }
}

