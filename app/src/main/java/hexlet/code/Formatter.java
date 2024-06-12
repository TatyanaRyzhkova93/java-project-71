package hexlet.code;


import hexlet.code.formatters.Format;
import hexlet.code.formatters.FormatFactory;

import java.util.Map;

public class Formatter {
    public static String createFormatter(String nameFormat, Map<String, Object> map) {
        FormatFactory formatFactory = new FormatFactory();
        Format format1 = formatFactory.getFormat(nameFormat);
        return format1.generateEquals(map);
    }

}
