package hexlet.code;

import java.util.Map;

public class Formatter {
    public static String createFormatter(String format, Map<String, Object> map) {
        String s = map.toString()
                .replace(", +", "\n+")
                .replace(", -", "\n-")
                .replace(",  ", "\n ")
                .replace("=", ": ")
                .replace("{ ", "\n{\n ")
                .replace("{+", "\n{\n+")
                .replace("{-", "\n{\n-");
        return s.substring(0, s.length() - 1) + "\n}";
    }

}
