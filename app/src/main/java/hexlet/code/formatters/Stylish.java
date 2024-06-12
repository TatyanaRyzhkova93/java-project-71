package hexlet.code.formatters;

import java.util.Map;

public class Stylish implements Format {

    @Override
    public String generateEquals(Map<String, Object> map) {
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
